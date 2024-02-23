package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.CreateIssue;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateIssueStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(CreateIssueStepDef.class);
    String createIssueEndPoint;
    CreateIssue createIssue;
    @When("The user sends Post request to create issue")
    public void theUserSendsPostRequestToCreateIssue() throws IOException {
        createIssueEndPoint = ConfigManager.getProperty("api.putEditIssueEndpoint");
        createIssue = TestDataReader.readData("create_issue.json", CreateIssue.class);
        logger.info(createIssue);
        response = sendPostRequest(createIssueEndPoint, createIssue);
    }
}
