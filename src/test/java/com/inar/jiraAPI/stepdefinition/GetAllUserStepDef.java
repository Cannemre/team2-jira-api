package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.response.User;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataWriter;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import java.io.FileNotFoundException;
import java.util.List;

public class GetAllUserStepDef extends BaseSteps {

    String getAllUsersEndPoint = ConfigManager.getProperty("api.getAllUsersEndPoint");
    List<User> actualAllUsersList;
    @When("The user sends GET request to get all users endpoint")
    public void theUserSendsGETRequestToGetAllUsersEndpoint() {
        response = sendGetRequest(getAllUsersEndPoint);
        actualAllUsersList = response.as(new TypeRef<>() {
        });
        try {
            TestDataWriter.writeData(actualAllUsersList.get(0), "user_information.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
