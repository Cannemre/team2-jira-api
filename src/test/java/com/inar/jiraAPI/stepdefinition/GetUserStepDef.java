package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.response.User;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class GetUserStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(GetUserStepDef.class);


    Map<String, String> queryParams = new HashMap<>();
    User expectedUser;
    User actualUser;
    String getUsersEndPoint = ConfigManager.getProperty("api.getUserEndPoint");

    @When("I send a GET request to with user ID for a specific user")
    public void iSendAGETRequestToWithUserIDForASpecificUser() {
        queryParams.put("accountId", expectedUser.getAccountId());
        response = sendGetRequest(getUsersEndPoint, queryParams);
    }

    @And("The user information is available")
    public void theUserInformationIsAvailable() throws IOException {
        expectedUser = TestDataReader.readData("user_information.json", User.class);
    }

    @And("the response should contains the user details")
    public void theResponseShouldContainsTheUserDetails() {
        actualUser = response.as(User.class);
        Assertions.assertThat(actualUser.getAccountId()).isEqualTo(expectedUser.getAccountId());
        Assertions.assertThat(actualUser.getAvatarUrls().getJsonMember16x16()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember16x16());
        Assertions.assertThat(actualUser.getAvatarUrls().getJsonMember24x24()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember24x24());
        Assertions.assertThat(actualUser.getAvatarUrls().getJsonMember32x32()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember32x32());
        Assertions.assertThat(actualUser.getAvatarUrls().getJsonMember48x48()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember48x48());
        Assertions.assertThat(actualUser.getDisplayName()).isEqualTo(expectedUser.getDisplayName());
        Assertions.assertThat(actualUser.getAccountType()).isEqualTo(expectedUser.getAccountType());
        Assertions.assertThat(actualUser.getSelf()).isEqualTo(expectedUser.getSelf());
        Assertions.assertThat(actualUser.isActive()).isEqualTo(expectedUser.isActive());
        logger.info("Assertion for user details");
    }

    @When("I send a GET request to with account {string} for a specific user")
    public void iSendAGETRequestToWithAccountForASpecificUser(String accountID) {
        queryParams.put("accountId", accountID);
        response = sendGetRequest(getUsersEndPoint, queryParams);
    }

    @And("The response account ID of users should match {string}")
    public void theResponseAccountIDOfUsersShouldMatch(String accountID) {
        actualUser = response.as(User.class);
        Assertions.assertThat(actualUser.getAccountId()).isEqualTo(accountID);
        logger.info("Assertion for account ID");
    }
}
