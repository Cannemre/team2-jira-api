package com.inar.jiraAPI.stepdefinition;

import io.cucumber.java.en.Then;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;


import static com.inar.jiraAPI.utils.APIUtils.*;


public class GetUsersSteps extends BaseSteps {
	private static final Logger logger = LogManager.getLogger(GetUsersSteps.class);

	@Then("I send get request to assert response for all users")
	public void sendGetRequestAndResponseStatusCodeShouldBe() {
		response = sendGetRequest(request, getAllUsersEndPoint);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
	}
}
