package com.inar.jiraAPI.stepdefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.inar.jiraAPI.javabeans.response.getProject.GetProject;
import com.inar.jiraAPI.javabeans.response.Project;
import com.inar.jiraAPI.utils.ConfigManager;
import com.inar.jiraAPI.utils.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class GetProjectStepDef extends BaseSteps{
    private static final Logger logger = LogManager.getLogger(GetProjectStepDef.class);
    String endPoint = ConfigManager.getProperty("api.getRecentProjects");
    String endPoint2 = ConfigManager.getProperty("api.getProject");

    List<Project> getProjects;
    List<Project> expectedGetProject;
    GetProject responseGetProject;
    GetProject refGetProject;

    @When("the client sends a Get request to get recent projects")
    public void the_client_sends_a_get_request_to_get_recent_projects() throws JsonProcessingException {
        response = sendGetRequest(endPoint);
        getProjects = response.as(new TypeRef<>() {
        });
    }

    @Then("the response should contain recent project data")
    public void the_response_should_contain_recent_project_data() throws IOException {
        expectedGetProject = objectMapper.readValue(new File("src/test/resources/test_data/getRecentProjects.json"), new TypeReference<>() {
        });
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < expectedGetProject.size(); i++) {
            softAssertions.assertThat(expectedGetProject.get(i).getProjectTypeKey()).isEqualTo(getProjects.get(i).getProjectTypeKey());
            softAssertions.assertThat(expectedGetProject.get(i).getEntityId()).isEqualTo(getProjects.get(i).getEntityId());
            softAssertions.assertThat(expectedGetProject.get(i).getSelf()).isEqualTo(getProjects.get(i).getSelf());
            softAssertions.assertThat(expectedGetProject.get(i).getId()).isEqualTo(getProjects.get(i).getId());
            softAssertions.assertThat(expectedGetProject.get(i).getExpand()).isEqualTo(getProjects.get(i).getExpand());
            softAssertions.assertThat(expectedGetProject.get(i).getKey()).isEqualTo(getProjects.get(i).getKey());
            softAssertions.assertThat(expectedGetProject.get(i).getName()).isEqualTo(getProjects.get(i).getName());
            softAssertions.assertThat(expectedGetProject.get(i).getSelf()).isEqualTo(getProjects.get(i).getSelf());
            softAssertions.assertThat(expectedGetProject.get(i).getStyle()).isEqualTo(getProjects.get(i).getStyle());
            softAssertions.assertThat(expectedGetProject.get(i).getUuid()).isEqualTo(getProjects.get(i).getUuid());
            softAssertions.assertThat(expectedGetProject.get(i).isSimplified()).isEqualTo(getProjects.get(i).isSimplified());
            softAssertions.assertThat(expectedGetProject.get(i).getAvatarUrls().getJsonMember16x16()).isEqualTo(getProjects.get(i).getAvatarUrls().getJsonMember16x16());
            softAssertions.assertThat(expectedGetProject.get(i).getAvatarUrls().getJsonMember24x24()).isEqualTo(getProjects.get(i).getAvatarUrls().getJsonMember24x24());
            softAssertions.assertThat(expectedGetProject.get(i).getAvatarUrls().getJsonMember32x32()).isEqualTo(getProjects.get(i).getAvatarUrls().getJsonMember32x32());
            softAssertions.assertThat(expectedGetProject.get(i).getAvatarUrls().getJsonMember48x48()).isEqualTo(getProjects.get(i).getAvatarUrls().getJsonMember48x48());
        }
        softAssertions.assertAll();
    }

    @When("the user sends a Get Invalid Request to get recent projets")
    public void theUserSendsAGetInvalidRequestToGetRecentProjets() {
        response = request.when().get("/rest/api/3/project/recen");
    }

    @And("the response should have the same project quantity with Recent Projects")
    public void theResponseShouldHaveTheSameProjectQuantityWithRecentProjects() throws IOException {
        getProjects = objectMapper.readValue(response.asString(), new TypeReference<>() {
        });
        expectedGetProject = objectMapper.readValue(new File("src/test/resources/test_data/getRecentProjects.json"), new TypeReference<>() {
        });
        Assertions.assertThat(expectedGetProject.size()).isEqualTo(2);
        //projects.size()
    }

    @And("the response should contain specific project")
    public void theResponseShouldContainSpecificProject() throws IOException {
        refGetProject = TestDataReader.readData("getProject-T2JA.json",GetProject.class);
        SoftAssertions softAssertions = new SoftAssertions();
        Assertions.assertThat(responseGetProject.getId()).isEqualTo(refGetProject.getId());
        Assertions.assertThat(responseGetProject.getName()).isEqualTo(refGetProject.getName());
        Assertions.assertThat(responseGetProject.getKey()).isEqualTo(refGetProject.getKey());
    }
    @When("the user send get request to Get Project Endpoint with second valid projectId")
    public void theUserSendGetRequestToGetProjectEndpointWithSecondValidProjectId() {
        response = request.when().get(endPoint2+"/TEAM2");
        responseGetProject = response.as(GetProject.class);
    }
    @When("the user send get request to Get Project Endpoint with valid projectId")
    public void theUserSendGetRequestToGetProjectEndpointWithValidProjectId() {
        response = sendGetRequest(endPoint2+"/T2JA");
        responseGetProject = response.as(GetProject.class);
    }
}
