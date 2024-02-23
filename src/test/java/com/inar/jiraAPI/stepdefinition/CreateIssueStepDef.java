package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.createissue.CreateIssue;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.io.IOException;

public class CreateIssueStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(CreateIssueStepDef.class);
    String createIssueEndPoint;
    CreateIssue createIssue;

    @When("The user sends Post request to create issue")
    public void theUserSendsPostRequestToCreateIssue() throws IOException {
        createIssueEndPoint = ConfigManager.getProperty("api.putEditIssueEndpoint");
        createIssue = TestDataReader.readData("create_issue.json", CreateIssue.class);
        response = sendPostRequest(createIssueEndPoint, createIssue);
        logger.debug("The user sends Post request to create issue");
    }

    @When("The user sends Post request to create issue with invalid specific issue key")
    public void theUserSendsPostRequestToCreateIssueWithInvalidSpecificIssueKey() throws IOException {
        createIssueEndPoint = ConfigManager.getProperty("api.putEditIssueEndpoint");
        createIssue = TestDataReader.readData("create_invalid_issue.json", CreateIssue.class);
        response = sendPostRequest(createIssueEndPoint, createIssue);
        logger.debug("The user sends Post request to create issue with invalid specific issue key");
    }

    @And("The user should get error message")
    public void theUserShouldGetErrorMessage() {
        String ActualErrorMessage = response.asPrettyString();
        Assertions.assertThat(ActualErrorMessage).contains("error");
        logger.info("The user receive error message");
    }
}
