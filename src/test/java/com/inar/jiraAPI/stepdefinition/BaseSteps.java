package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps {

	static protected Response response;

	protected static RequestSpecification request;

	protected static String getAllUsersEndPoint;




	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
		request = RestAssured.given().auth().preemptive().basic(ConfigManager.getProperty("authUsername"), ConfigManager.getProperty("authToken"));
		getAllUsersEndPoint = ConfigManager.getProperty("api.getAllUsersEndPoint");

	}

}
