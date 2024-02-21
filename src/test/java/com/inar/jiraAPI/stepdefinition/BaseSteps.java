package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.APIUtils;
import com.inar.jiraAPI.utils.ConfigManager;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

public abstract class BaseSteps extends APIUtils {

	static protected Response response;

	public BaseSteps() {
		baseURI = ConfigManager.getProperty("base.uri");
	}

}
