package woowaapplication.individual.moim.utils;

import org.springframework.beans.factory.InitializingBean;

public interface DatabaseCleaner extends InitializingBean {
        void afterPropertiesSet();
        void execute();
}
