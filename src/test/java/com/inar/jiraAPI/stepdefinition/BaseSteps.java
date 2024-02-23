package com.inar.jiraAPI.stepdefinition;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inar.jiraAPI.utils.APIUtils;
import com.inar.jiraAPI.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps extends APIUtils {

	static protected Response response;
	static protected ObjectMapper objectMapper = new ObjectMapper();
	public BaseSteps() {

		baseURI = ConfigManager.getProperty("base.uri");
	}

}
