package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class GetIssueStepDef extends BaseSteps {

    private static final Logger logger = LogManager.getLogger(GetIssueStepDef.class);
    String getIssueEndPoint;


    @When("The user sends Get request to create issue with specific issue key as {string}")
    public void theUserSendsGetRequestToCreateIssueWithSpecificIssueKeyAs(String key) {
        getIssueEndPoint = ConfigManager.getProperty("api.putEditIssueEndpoint") + "/" + key;
        response = sendGetRequest(getIssueEndPoint);
        logger.debug("The user sends Get request to create issue with specific issue key");
    }

    @And("Issue id is not null and empty")
    public void ıssueIdIsNotNullAndEmpty() {
        String id = response.jsonPath().getString("id");
        Assertions.assertThat(id).isNotEmpty();
        Assertions.assertThat(id).isNotNull();
        logger.info("Issue id is not null and empty");
    }

    @When("The user sends Get request to create issue with specific invalid issue key as {string}")
    public void theUserSendsGetRequestToCreateIssueWithSpecificInvalidIssueKeyAs(String key) {
        getIssueEndPoint = ConfigManager.getProperty("api.putEditIssueEndpoint") + "/" + key;
        response = sendGetRequest(getIssueEndPoint);
        logger.debug("The user sends Get request to create issue with specific invalid issue key as");
    }


    @And("The error message should be displayed")
    public void theErrorMessageShouldBeDisplayed() {
        String errorMessage = (String) response.jsonPath().getList("errorMessages").get(0);
        Assertions.assertThat(errorMessage).isNotEmpty();
        logger.info("The user receive error message");
    }
}
