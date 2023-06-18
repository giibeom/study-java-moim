package woowaapplication.individual.moim.member.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false, length = 1)
    @Enumerated(STRING)
    private Gender gender;

    @Column(nullable = false, length = 1)
    @Enumerated(STRING)
    private MemberRole role;

    @Column(nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(length = 100)
    private String email;

    @Builder
    private Member(
            String name, LocalDate birth,
            Gender gender, MemberRole role,
            String loginId, String password, String email
    ) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.role = role;
        this.loginId = loginId;
        this.password = password;
        this.email = email;
    }
}
