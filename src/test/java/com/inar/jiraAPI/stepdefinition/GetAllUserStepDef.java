package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.javabeans.response.User;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetAllUserStepDef extends BaseSteps {
    private static final Logger logger = LogManager.getLogger(GetAllUserStepDef.class);
    String getAllUsersEndPoint = ConfigManager.getProperty("api.getAllUsersEndPoint");
    List<User> responseList;
    List<User> refList;



    @When("The user sends GET request to get all users endpoint")
    public void theUserSendsGETRequestToGetAllUsersEndpoint() throws IOException {
        refList = TestDataReader.readDataList("database.json", User.class);
        response = sendGetRequest(getAllUsersEndPoint);
        responseList = response.as(new TypeRef<>() {
        });
        Assertions.assertThat(responseList).containsExactlyInAnyOrderElementsOf(refList);
        logger.info("Assertion for all users is made");
    }

    @When("The user sends GET request to get all users endpoint with startAt query parameter {string}")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithStartAtQueryParameterStartsAt(String startAt) throws IOException {
        refList = TestDataReader.readDataList("database.json", User.class);
        Map<String,String> queryParams = new HashMap<>(){{
            put("startAt",startAt);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
        responseList = response.as(new TypeRef<>() {
        });
        refList = refList.subList(Integer.parseInt(startAt),refList.size());
        Assertions.assertThat(responseList).containsExactlyInAnyOrderElementsOf(refList);
        logger.info("Assertion for startAt query parameters is made");

    }

    @When("The user sends GET request to get all users endpoint with maxResult query parameter {string}")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithMaxResultQueryParameter(String maxResults) throws IOException {
        refList = TestDataReader.readDataList("database.json", User.class);
        Map<String,String> queryParams = new HashMap<>(){{
            put("maxResults",maxResults);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
        responseList = response.as(new TypeRef<>() {
        });
        Assertions.assertThat(responseList).hasSizeLessThanOrEqualTo(Integer.parseInt(maxResults));
        logger.info("Assertion for max results query parameters is made");
    }

    @Then("The user sends GET request to get all users endpoint to verify response")
    public void theUserSendsGETRequestToGetAllUsersEndpointToVerifyResponse() {
        response = sendGetRequest(getAllUsersEndPoint);
        logger.info("Request for all users is sent to endpoint without valid credentials");
    }

    @When("The user sends GET request to get all users endpoint with startAt query parameter {string} to verify response")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithStartAtQueryParameterToVerifyResponse(String startAt) {
        Map<String,String> queryParams = new HashMap<>(){{
            put("startAt",startAt);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
        logger.info("Request for all users is sent with start at parameter to endpoint without valid credentials");

    }

    @When("The user sends GET request to get all users endpoint with maxResult query parameter {string} to verify response")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithMaxResultQueryParameterToVerifyResponse(String maxResults) {
        Map<String,String> queryParams = new HashMap<>(){{
            put("maxResults",maxResults);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
        logger.info("Request for all users is sent with max result parameter to endpoint without valid credentials");
    }

    @When("The user sends GET request to get all users endpoint with multiple query parameters {string} {string}")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithMultipleQueryParameters(String maxResults, String startAt) throws IOException {
        refList = TestDataReader.readDataList("database.json", User.class);
        Map<String,String> queryParams = new HashMap<>(){{
            put("startAt",startAt);
            put("maxResults",maxResults);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
        responseList = response.as(new TypeRef<>() {
        });
        Assertions.assertThat(responseList).hasSizeLessThanOrEqualTo(Integer.parseInt(maxResults));
        refList = refList.subList(Integer.parseInt(startAt),refList.size());
        Assertions.assertThat(responseList).containsExactlyInAnyOrderElementsOf(refList);
        logger.info("Assertion for two query parameters is made");
    }

    @When("The user sends GET request to get all users endpoint with multiple query parameters {string} {string} to verify response")
    public void theUserSendsGETRequestToGetAllUsersEndpointWithMultipleQueryParametersToVerifyResponse(String startAt, String maxResults) {
        Map<String,String> queryParams = new HashMap<>(){{
            put("startAt",startAt);
            put("maxResults",maxResults);
        }};
        response = sendGetRequest(getAllUsersEndPoint,queryParams);
    }


}
