package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.response.User;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUsersStepDef extends BaseSteps{

    String findUsersEndPoint = ConfigManager.getProperty("api.findUsersEndPoint");
    Map<String, String> queryParams = new HashMap<>();
    List<User> users;
    User expectedUser;
    List<User> actualUser;
    @When("The user sends GET request to find users end point with user {string}")
    public void theUserSendsGETRequestToFindUsersEndPointWithUser(String email) {
        queryParams.put("query", email);
        response = sendGetRequest(findUsersEndPoint,queryParams);
        users = response.as(new TypeRef<>() {
        });
    }


    @And("The response email address of users should match {string}")
    public void theResponseEmailAddressOfUsersShouldMatch(String email) {
        Assertions.assertThat(users.get(0).getEmailAddress()).isEqualTo(email);
    }

    @When("I send a GET request to with user {string} for a specific user")
    public void iSendAGETRequestToWithUserForASpecificUser(String name) {
        queryParams.put("query", name);
        response = sendGetRequest(findUsersEndPoint,queryParams);
        users = response.as(new TypeRef<>() {
        });
    }

    @And("the response should contains the user details for a specific user")
    public void theResponseShouldContainsTheUserDetailsForASpecificUser() throws IOException {
        expectedUser = TestDataReader.readData("user_information.json", User.class);
        actualUser = response.as(new TypeRef<>() {
        });
        Assertions.assertThat(actualUser.get(0).getAccountId()).isEqualTo(expectedUser.getAccountId());
        Assertions.assertThat(actualUser.get(0).getAvatarUrls().getJsonMember16x16()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember16x16());
        Assertions.assertThat(actualUser.get(0).getAvatarUrls().getJsonMember24x24()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember24x24());
        Assertions.assertThat(actualUser.get(0).getAvatarUrls().getJsonMember32x32()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember32x32());
        Assertions.assertThat(actualUser.get(0).getAvatarUrls().getJsonMember48x48()).isEqualTo(expectedUser.getAvatarUrls().getJsonMember48x48());
        Assertions.assertThat(actualUser.get(0).getDisplayName()).isEqualTo(expectedUser.getDisplayName());
        Assertions.assertThat(actualUser.get(0).getAccountType()).isEqualTo(expectedUser.getAccountType());
        Assertions.assertThat(actualUser.get(0).getSelf()).isEqualTo(expectedUser.getSelf());
        Assertions.assertThat(actualUser.get(0).isActive()).isEqualTo(expectedUser.isActive());
        Assertions.assertThat(actualUser.get(0).getLocale()).isEqualTo(expectedUser.getLocale());
    }
}
