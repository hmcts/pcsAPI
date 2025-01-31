package uk.gov.hmcts.reform.pcs.functional.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import uk.gov.hmcts.reform.pcs.functional.steps.ApiSteps;

@ExtendWith(SerenityJUnit5Extension.class)
class SampleFunctionalTest {

    private static final String BASE_URL = System.getProperty("TEST_URL", "http://localhost:8080");

    @Steps
    ApiSteps apiSteps;

    @BeforeEach
    void setUp() {
        apiSteps.setupBaseUrl(BASE_URL);
    }

    @Test
    void testHealth() {
        apiSteps.getHealth();
    }

    @Test
    @Tag("Functional")
    void testHealth2() {
        apiSteps.getHealth();
    }
}
