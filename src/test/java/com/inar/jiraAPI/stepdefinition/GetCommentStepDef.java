package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class GetCommentStepDef extends BaseSteps {

    String getCommentIssues;

    @When("The user sends get request to the Get Comment endpoint with specific key as {string} and specific id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithSpecificKeyAsAndSpecificIdAs(String key, String commentId) {
        getCommentIssues = ConfigManager.getProperty("api.comment.endpoint") + "/" + key + "/comment/" + commentId;
        response = sendGetRequest(getCommentIssues);
    }

    @And("The Time should be under {int} ms on the response")
    public void theTimeShouldBeUnderMsOnTheResponse(int time) {
        System.out.println(response.getTime());
        Assertions.assertThat(response.getTime()).isLessThan(time);
    }

    @And("The response text should be {string}")
    public void theResponseTextShouldBe(String text) {
        Assertions.assertThat(response.jsonPath().getString("body.content[0].content[0].text")).isEqualTo(text);
    }

    @And("The id should not be null and empty on the response")
    public void theIdShouldNotBeNullAndEmptyOnTheResponse() {
        String id = response.jsonPath().getString("id");
        Assertions.assertThat(id).isNotEmpty();
        Assertions.assertThat(id).isNotNull();

    }

    @When("The user sends get request to the Get Comment endpoint with specific key as {string} and invalid id as {string}")
    public void theUserSendsGetRequestToTheGetCommentEndpointWithInvalid(String key, String commentId) {
        getCommentIssues = ConfigManager.getProperty("api.comment.endpoint") + "/" + key + "/comment/" + commentId;
        response = sendGetRequest(getCommentIssues);
    }

    @And("The user should receive an error message")
    public void theUserShouldReceiveAnErrorMessage() {
        String errorMessage = (String) (response.jsonPath().getList("errorMessages").get(0));
        System.out.println(errorMessage);
    }


}
