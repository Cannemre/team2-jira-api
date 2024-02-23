package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.cucumber.java.en.When;

public class DeleteAttachmentStepDef extends BaseSteps{
    String deleteAttachmentEndPoint;
    @When("The user sends DELETE request to the delete attachment endpoint with specific id as {string}")
    public void theUserSendsDELETERequestToTheDeleteAttachmentEndpointWithSpecificIssueKeyAsAndSpecificIdAs( String id) {
        deleteAttachmentEndPoint = ConfigManager.getProperty("api.deleteAttachmentEndPoint")+id;
        response = sendDeleteRequest(deleteAttachmentEndPoint);
    }
}
