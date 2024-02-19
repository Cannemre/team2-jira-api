package com.inar.jiraAPI.stepdefinition;

import com.inar.jiraAPI.utils.APIUtils;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {

	@Then("send get request and response status code should be {int}")
	public void sendGetRequestAndResponseStatusCodeShouldBe(int httpStatusCode) {
		response = APIUtils.sendGetRequest(request, getAllUsersEndPoint);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(httpStatusCode);
	}
}
