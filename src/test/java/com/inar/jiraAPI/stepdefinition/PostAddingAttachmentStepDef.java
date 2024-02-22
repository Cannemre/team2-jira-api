package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.response.AttachmentInformation;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PostAddingAttachmentStepDef extends BaseSteps {

    private static final Logger logger = LogManager.getLogger(PostAddingAttachmentStepDef.class);

    List<AttachmentInformation> attachmentInformation;

    List<AttachmentInformation> expectedAttachmentInformation;

    SoftAssertions softAssertions = new SoftAssertions();

    String postAddAttachmentEndpoint = ConfigManager.getProperty("api.postAddAttachmentEndpoint");
    @When("I send a POST request with a specific key {string}")
    public void iSendAPOSTRequestWithASpecificKey(String key) {

        response = sendPostRequest(postAddAttachmentEndpoint, key);

        attachmentInformation = response.as(new TypeRef<>() {
        });
    }

    @And("Verify that the details of the attachment match those of the response")
    public void verifyThatTheDetailsOfTheAttachmentMatchThoseOfTheResponse() throws IOException {

        expectedAttachmentInformation = TestDataReader.readDataList("add_attachment.json", AttachmentInformation.class);

        softAssertions.assertThat(attachmentInformation.get(0).getFilename()).isEqualTo(expectedAttachmentInformation.get(0).getFilename());
        softAssertions.assertThat(attachmentInformation.get(0).getAuthor().getDisplayName()).isEqualTo(expectedAttachmentInformation.get(0).getAuthor().getDisplayName());
        softAssertions.assertAll();
    }

    @When("I send a POST request with a specific key {string} and {string}")
    public void iSendAPOSTRequestWithASpecificKeyAnd(String key, String fileName) throws FileNotFoundException {

        try{
            response = sendPostRequest(postAddAttachmentEndpoint, key, fileName);
            attachmentInformation = response.as(new TypeRef<>() {
            });
        }catch(Exception ex){
            logger.error("File not found",ex);
            throw new FileNotFoundException();
        }
    }

    @And("The response file_name should match {string}")
    public void theResponseFile_nameShouldMatch(String fileName) {

       Assertions.assertThat(attachmentInformation.get(0).getFilename()).isEqualTo(fileName);
    }
}
