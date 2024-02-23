package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.request.ContentItem;
import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.When;

public class DeleteComment extends BaseSteps{
    String deleteEndPoint;
    @When("The user sends DELETE request to the delete comment endpoint with specific issue key as {string} and specific id as {string}")
    public void theUserSendsDELETERequestToTheDeleteCommentEndpointWithSpecificIssueKeyAsAndSpecificIdAs(String key, String id) {
        deleteEndPoint = ConfigManager.getProperty("api.addCommentEndPoint")+"/"+key+"/comment/"+id;
        response = sendDeleteRequest(deleteEndPoint);
    }

    @When("The user sends DELETE request to the delete comment endpoint with specific issue key as {string} and specific invalid id as {string}")
    public void theUserSendsDELETERequestToTheDeleteCommentEndpointWithSpecificIssueKeyAsAndSpecificInvalidIdAs(String key, String id) {
        deleteEndPoint = ConfigManager.getProperty("api.addCommentEndPoint")+"/"+key+"/comment/"+id;
        response = sendDeleteRequest(deleteEndPoint);
    }
}
