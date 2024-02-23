package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.EditIssue;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.io.IOException;

public class PutEditIssueStepDef extends BaseSteps {

    private static final Logger logger = LogManager.getLogger(PutEditIssueStepDef.class);

    EditIssue editissue;

    @When("I send a PUT request with a specific key {string}")
    public void iSendAPUTRequestWithASpecificKey(String key) throws IOException {

        editissue = TestDataReader.readData("edit_issue.json", EditIssue.class);

        String putEditIssueEndpoint = ConfigManager.getProperty("api.putEditIssueEndpoint") + "/" + key;

        response = sendPutRequest(putEditIssueEndpoint,editissue);

        logger.info("I send a PUT request to edit issue");
    }

    @And("The Time should be under {int} ms on the response")
    public void theTimeShouldBeUnderIntMsOnTheResponse(int time) {

        Assertions.assertThat(response.getTime()).as("The time has exceeded its limitations").isLessThan(time);
    }
}