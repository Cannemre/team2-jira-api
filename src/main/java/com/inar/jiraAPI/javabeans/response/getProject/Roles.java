package com.inar.jiraAPI.javabeans.response.getProject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @JsonProperty("atlassian-addons-project-access")
    private String atlassianAddonsProjectAccess;
    public String Administrator;
    public String Viewer;
    public String Member;
}
