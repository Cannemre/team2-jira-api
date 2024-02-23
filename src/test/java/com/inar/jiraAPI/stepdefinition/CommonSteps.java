package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.BadRequest;
import com.inar.jiraAPI.stepdefinition.hook.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

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
        logger.info("Request is set to valid auth");
    }
    @Given("The authentication is made with invalid token to connect with api endpoints")
    public void theAuthenticationIsMadeWithInvalidTokenToConnectWithApiEndpoints() {
        if (username == null ) {
            username = System.getenv("authUsername");

            if (username == null) {
                throw new IllegalArgumentException("Username can not be null");
            }
        }
        request = RestAssured.given().auth().preemptive().basic(username, "invalidTokenStandsHere");
        logger.info("Request is set to invalid token");
    }
    @Given("The authentication is made with invalid username to connect with api endpoints")
    public void theAuthenticationIsMadeWithInvalidUsernameToConnectWithApiEndpoints() {
        if (token == null) {
            token = System.getenv("authToken");

            if (token == null) {
                throw new IllegalArgumentException("Token can not be null");
            }
        }
        request = RestAssured.given().auth().preemptive().basic("fakeid@gmail.com", token);
        logger.info("Request is set to invalid username");

    }

    @Given("The authentication is made with invalid content type to connect with api endpoints")
    public void theAuthenticationIsMadeWithInvalidContentTypeToConnectWithApiEndpoints() {
        if (username == null || token == null) {
            username = System.getenv("authUsername");
            token = System.getenv("authToken");

            if (username == null || token == null) {
                throw new IllegalArgumentException("Username or token can not be null");
            }
        }
        request = RestAssured.given().auth().preemptive().basic(username, token).header("Accept","plain/text");
        logger.info("Request is set to invalid contentType");

    }

    @Then("Response status code should be {int}")
    public void sendGetRequestAndResponseStatusCodeShouldBe(int httpStatusCode) {
        Assertions.assertThat(response.getStatusCode()).isEqualTo(httpStatusCode);
    }

    @Given("The authentication is made with invalid body to connect with api endpoints")
    public void theAuthenticationIsMadeWithInvalidBodyToConnectWithApiEndpoints() {
        if (username == null || token == null) {
            username = System.getenv("authUsername");
            token = System.getenv("authToken");

            if (username == null || token == null) {
                throw new IllegalArgumentException("Username or token can not be null");
            }
        }
        BadRequest badRequest = new BadRequest("Jason","Application");
        request = RestAssured.given().auth().preemptive().basic(username, token).body(badRequest);
    }
}
