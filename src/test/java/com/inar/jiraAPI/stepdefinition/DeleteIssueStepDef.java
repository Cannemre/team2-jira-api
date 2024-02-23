package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class DeleteIssueStepDef extends BaseSteps{
    private final String deleteIssue = ConfigManager.getProperty("api.putEditIssueEndpoint");
    private static final Logger logger = LogManager.getLogger(DeleteIssueStepDef.class);
    @Then("I try to delete an issue with {string}")
    public void iTryToDeleteAnIssue(String issueKey) {
        String[] pathParam = {"issueIdOrKey",issueKey};
        response = sendDeleteRequest(deleteIssue,pathParam);
        logger.info("Delete request is sent for " + issueKey);
    }

    @Then("I try to delete an issue with {string} and {string}")
    public void iTryToDeleteAnIssueWithAnd(String issueKey, String deleteSubtasks) {
        String[] pathParam = {"issueIdOrKey",issueKey};
        Map<String,Boolean> queryParams = new HashMap<>(){{
            put("deleteSubtasks",Boolean.valueOf(deleteSubtasks));
        }};
        response = sendDeleteRequest(deleteIssue,pathParam,queryParams);
        logger.info("Delete request is sent for " + issueKey + " " + queryParams);
    }
}
