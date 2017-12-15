package io.pestakit.integration.api.spec.helpers;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Miguel Santamaria on 14/12/17.
 */
public class Environment {

    private io.pestakit.users.api.DefaultApi usersApi = new io.pestakit.users.api.DefaultApi();
    private io.pestakit.surveys.api.DefaultApi surveysApi = new io.pestakit.surveys.api.DefaultApi();

    public Environment() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("environment.properties"));
        String usersUrl = properties.getProperty("io.pestakit.users.server.url");
        String surveysUrl = properties.getProperty("io.pestakit.surveys.server.url");
        usersApi.getApiClient().setBasePath(usersUrl);
        surveysApi.getApiClient().setBasePath(surveysUrl);
    }

    public io.pestakit.users.api.DefaultApi getUsersApi() {
        return usersApi;
    }

    public io.pestakit.surveys.api.DefaultApi getSurveysApi() {
        return surveysApi;
    }
}
