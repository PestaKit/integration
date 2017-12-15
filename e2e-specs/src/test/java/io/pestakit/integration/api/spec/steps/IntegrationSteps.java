package io.pestakit.integration.api.spec.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.pestakit.integration.api.spec.helpers.Environment;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Miguel Santamaria on 15/12/17.
 */
public class IntegrationSteps {

    private Environment environment;
    private io.pestakit.users.api.DefaultApi usersApi;
    private io.pestakit.surveys.api.DefaultApi surveysApi;

    public IntegrationSteps(Environment environment) {
        this.environment = environment;
        this.usersApi = environment.getUsersApi();
        this.surveysApi = environment.getSurveysApi();
    }

    @Given("^there is a Users server$")
    public void there_is_a_Users_server() throws Throwable {
        assertNotNull(environment.getUsersApi());
    }

    @And("^there is a Surveys server$")
    public void there_is_a_Surveys_server() throws Throwable {
        assertNotNull(environment.getSurveysApi());
    }
}
