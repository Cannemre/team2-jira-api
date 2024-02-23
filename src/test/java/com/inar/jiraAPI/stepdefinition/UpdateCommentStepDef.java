package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.request.UpdateComment;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class UpdateCommentStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(UpdateCommentStepDef.class);
    String updateCommentEndpoint;
    UpdateComment updateComment;

    @When("The user sends PUT request to the Update Comment endpoint with specific issue key {string} and comment id as {string}")
    public void theUserSendsPUTRequestToTheUpdateCommentEndpointWithSpecificIssueKeyAndCommentIdAs(String issueKey, String commentId) throws IOException {
        updateComment = TestDataReader.readData("update_comment.json", UpdateComment.class);
        updateCommentEndpoint = ConfigManager.getProperty("api.comment.endpoint") + "/" + issueKey + "/comment/" + commentId;
        response = sendGetRequest(updateCommentEndpoint, updateComment);
        logger.debug("The user sends PUT request to the Update Comment endpoint with specific issue key and comment id as");
    }

    @And("The content of request should match with the content of the response")
    public void theContentOfRequestShouldMatchWithTheContentOfTheResponse() {
        String actualText = response.jsonPath().getString("body.content[0].content[0].text");
        String expectedText = updateComment.getBody().getContent().get(0).getContent().get(0).getText();
        then(actualText).isEqualTo(expectedText);
        logger.info("The user see that the content of request should match with the content of the response ");
    }

    @When("The user sends PUT request to the Update Comment endpoint with specific issue key {string} and invalid comment id as {string}")
    public void theUserSendsPutRequestToTheUpdateCommentEndpointWithSpecificIssueKeyAndInvalidCommentId(String issueKey, String commentId) throws IOException {
        updateComment = TestDataReader.readData("update_comment.json", UpdateComment.class);
        updateCommentEndpoint = ConfigManager.getProperty("api.comment.endpoint") + "/" + issueKey + "/comment/" + commentId;
        response = sendGetRequest(updateCommentEndpoint, updateComment);
        logger.debug("The user sends PUT request to the Update Comment endpoint with specific issue key and invalid comment id as");

    }

}