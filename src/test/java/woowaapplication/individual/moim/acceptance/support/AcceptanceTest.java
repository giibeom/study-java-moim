package woowaapplication.individual.moim.acceptance.support;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import woowaapplication.individual.moim.utils.DatabaseCleaner;
import woowaapplication.individual.moim.utils.H2DatabaseCleaner;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTest {

    @Autowired
    @Qualifier("h2DatabaseCleaner")
    private DatabaseCleaner databaseCleaner;

    @BeforeEach
    protected void setUp() {
        databaseCleaner.execute();
    }
}
