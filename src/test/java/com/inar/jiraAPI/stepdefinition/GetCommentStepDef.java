package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class GetCommentStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(GetCommentStepDef.class);
    String getCommentIssues;

    @When("The user sends GET request to the Get Comment endpoint with specific key as {string} and specific id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String commentId) {
        getCommentIssues = ConfigManager.getProperty("api.comment.endpoint") + "/" + key + "/comment/" + commentId;
        response = sendGetRequest(getCommentIssues);
        logger.debug("The user sends get request to the Get Comment endpoint with specific key and specific id");
    }


    @And("The response text should match {string}")
    public void theResponseTextShouldBe(String text) {
        Assertions.assertThat(response.jsonPath().getString("body.content[0].content[0].text")).isEqualTo(text);
        logger.info("The response text should match expected text");
    }

    @And("The id should not be null and empty on the response")
    public void theIdShouldNotBeNullAndEmptyOnTheResponse() {
        String id = response.jsonPath().getString("id");
        Assertions.assertThat(id).isNotEmpty();
        Assertions.assertThat(id).isNotNull();
        logger.info("The id should not be null and empty on the response");
    }

    @When("The user sends GET request to the Get Comment endpoint with specific key as {string} and invalid id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithInvalid(String key, String commentId) {
        getCommentIssues = ConfigManager.getProperty("api.comment.endpoint") + "/" + key + "/comment/" + commentId;
        response = sendGetRequest(getCommentIssues);
        logger.debug("The user sends get request to the Get Comment endpoint with specific key and invalid id");
    }

    @And("The user should receive an error message")
    public void theUserShouldReceiveAnErrorMessage() {
        String errorMessage = (String) (response.jsonPath().getList("errorMessages").get(0));
        Assertions.assertThat(errorMessage).isNotEmpty();
        logger.info("The user should receive an error message");

    }
}
