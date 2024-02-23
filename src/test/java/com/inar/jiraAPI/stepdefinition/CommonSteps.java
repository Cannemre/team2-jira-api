package com.inar.jiraAPI.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {
   static String username = null;
   static String token = null;

    @Given("The authentication is made to connect with api endpoints")
    public void theAuthenticationIsMadeToConnectWithApiEndpoints() {
        if (username == null || token == null) {
            username = System.getenv("authUsername");
            token = System.getenv("authToken");
        }
        request = RestAssured.given().auth().preemptive().basic(username, token);
    }

    @Then("Response status code should be {int}")
    public void sendGetRequestAndResponseStatusCodeShouldBe(int httpStatusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(httpStatusCode);
    }
}


/**
 *  String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();
 *
 *         String actualText = response.jsonPath().getString("body.content[0].content[0].text");
 */