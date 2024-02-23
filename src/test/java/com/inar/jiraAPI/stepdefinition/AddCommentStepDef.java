package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.AddComment;
import com.inar.jiraAPI.javabeans.response.User;
import com.inar.jiraAPI.utils.APIUtils;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.util.List;

public class AddCommentStepDef extends BaseSteps {
    AddComment addComment;
    private static final Logger logger = LogManager.getLogger(GetAllUserStepDef.class);

    String addCommentEndPoint;

    @When("The user sends POST request to add comment endpoint with specific issue key as {string}")
    public void theUserSendsPOSTRequestToAddCommentEndpointWithSpecificIssueKey(String issueKey) throws IOException {
        addCommentEndPoint = ConfigManager.getProperty("api.addCommentEndPoint") + "/" + issueKey + "/comment";
        addComment = TestDataReader.readData("add_comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(addCommentEndPoint, addComment);
    }

    @And("The comment id should not be empty or null")
    public void theCommentIdShouldNotBeEmptyOrNull() {
       String id = response.jsonPath().getString("id");
        Assertions.assertThat(id).isNotNull();
        Assertions.assertThat(id).isNotEmpty();
    }

    @And("The response text should be same with the given text in json file")
    public void theResponseTextShouldBeSameWithTheGivenTextInJsonFile() {
        String actualText = response.jsonPath().getString("body.content[0].content[0].text");
        String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();
        Assertions.assertThat(actualText).isEqualTo(expectedText);

    }

    @When("The user sends POST request to add comment endpoint with specific invalid issue key as {string}")
    public void theUserSendsPOSTRequestToAddCommentEndpointWithSpecificInvalidIssueKeyAs(String issueKey) throws IOException {
        addCommentEndPoint = ConfigManager.getProperty("api.addCommentEndPoint") + "/" + issueKey + "/comment";
        addComment = TestDataReader.readData("add_comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(addCommentEndPoint, addComment);
    }
}
