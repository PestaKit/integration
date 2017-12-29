package io.pestakit.integration.api.spec.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.pestakit.integration.api.spec.helpers.Environment;
import io.pestakit.users.api.dto.User;


import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Miguel Santamaria on 15/12/17.
 * modified by Adrien Marco 29/12/17.
 */
public class IntegrationSteps {

    private Environment environment;

    //API users
    private io.pestakit.users.api.DefaultApi usersApi;
    private io.pestakit.users.ApiResponse lastApiResponseUsersApi;
    private io.pestakit.users.ApiException lastApiExceptionUsersApi;
    private boolean lastApiCallThrewExceptionUsersApi;
    private int lastStatusCodeUsersApi;
    private User user;
    private long uid;

    //API Surveys
    private io.pestakit.surveys.api.DefaultApi surveysApi;
    private io.pestakit.surveys.ApiResponse lastApiResponseSurveysApi;
    private io.pestakit.surveys.ApiException lastApiExceptionSurveysApi;
    private boolean lastApiCallThrewExceptionSurveysApi;
    private int lastStatusCodeSurveysApi;






    public IntegrationSteps(Environment environment) {
        this.environment = environment;
        this.usersApi = environment.getUsersApi();
        this.surveysApi = environment.getSurveysApi();
    }






    @Given("^there is a Users server$")
    public void there_is_a_Users_server() throws Throwable {
        assertNotNull(environment.getUsersApi());
    }

    @Given("^I have a correct payload to create a user$")
    public void i_have_a_correct_payload_to_create_a_user() throws Throwable {
        iHaveAUserNamedPayload("Ali");
    }

    @Given("^I have a user named (.+) payload$")
    public void iHaveAUserNamedPayload(String name) throws Throwable {
        uid = new Date().getTime();
        createUserPayload(name);
    }

    private void createUserPayload(String name){
        name = uid + name;
        user = new User();
        user.username("user"+name);
        user.password("pass"+name);
        user.setEmail(name+"@"+name+".com");
        user.setFirstName("first"+name);
        user.setLastName("last"+name);
        user.setDisplayName("display"+name);
    }






    @When("^I POST it to the /users endpoint$")
    public void i_POST_it_to_the_users_endpoint() throws Throwable {
        try {
            lastApiResponseUsersApi = usersApi.createUserWithHttpInfo(user);
            lastApiCallThrewExceptionUsersApi = false;
            lastApiExceptionUsersApi = null;
            lastStatusCodeUsersApi = lastApiResponseUsersApi.getStatusCode();
        } catch (io.pestakit.users.ApiException e) {
            lastApiCallThrewExceptionUsersApi = true;
            lastApiResponseUsersApi = null;
            lastApiExceptionUsersApi = e;
            lastStatusCodeUsersApi = lastApiExceptionUsersApi.getCode();
        }
    }





    @Then("^I receive a (\\d+) user API status code$")
    public void i_receive_a_user_api_status_code(int code) throws Throwable {
        assertEquals(code, lastStatusCodeUsersApi);
    }

    @And("^there is a Surveys server$")
    public void there_is_a_Surveys_server() throws Throwable {
        assertNotNull(environment.getSurveysApi());
    }



}
