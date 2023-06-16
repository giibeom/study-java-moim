package woowaapplication.individual.moim.utils;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Profile("test")
@Component
public class H2DatabaseCleaner implements DatabaseCleaner {

    @PersistenceContext
    private EntityManager entityManager;

    private List<String> tableNames;

    /**
     * 엔티티 정보를 순회하여 테이블명을 추출합니다.
     */
    @Override
    public void afterPropertiesSet() {
        tableNames = entityManager.getMetamodel().getEntities().stream()
                .filter(entity -> entity.getJavaType().getAnnotation(Entity.class) != null)
                .map(entity -> entity.getName())
                .collect(Collectors.toList());
    }

    @Transactional
    public void execute() {
        // 영속성 컨텍스트의 쓰기 지연 저장소에 있는 SQL 모두 적용
        entityManager.flush();
        // 참조(fk) 무결성 비활성화 : 연관 관계 맵핑된 테이블이 있는 경우 참조 무결성을 해제 해주어야 TRUNCATE 작업 가능
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();

        for (String tableName : tableNames) {
            // H2 database에서 PK를 초기화하려면 TRUNCATE 명령문에 RESTART IDENTITY를 추가해야 함
            // ref: https://www.h2database.com/html/commands.html?highlight=truncate&search=truncate#truncate_table
            entityManager.createNativeQuery("TRUNCATE TABLE " + tableName + " RESTART IDENTITY").executeUpdate();
        }

        // 참조(fk) 무결성 활성화
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
}