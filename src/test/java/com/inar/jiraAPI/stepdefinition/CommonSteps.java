package com.inar.jiraAPI.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {
    String username = null;
    String token = null;

    @Given("The authentication is made to connect with api endpoints")
    public void theAuthenticationIsMadeToConnectWithApiEndpoints() {
        if (username == null || token == null) {
            username = System.getenv("authUsername");
            token = System.getenv("authToken");

            if (username == null || token == null) {
                throw new IllegalArgumentException("Username or token can not be null");
            }
        }
        request = RestAssured.given().auth().preemptive().basic(username, token);
    }

    @Then("Response status code should be {int}")
    public void sendGetRequestAndResponseStatusCodeShouldBe(int httpStatusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(httpStatusCode);
    }


}
