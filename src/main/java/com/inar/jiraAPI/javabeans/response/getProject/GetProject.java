package com.inar.jiraAPI.javabeans.response.getProject;

import com.inar.jiraAPI.javabeans.response.AvatarUrls;
import com.inar.jiraAPI.javabeans.response.Properties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetProject {
    private String expand;
    private String self;
    private String id;
    private String key;
    private String description;
    private Lead lead;
    private List<Component> components;
    private List<IssueType> issueTypes;
    private String assigneeType;
    private List<Version> versions;
    private String name;
    private Roles roles;
    private AvatarUrls avatarUrls;
    private String projectTypeKey;
    private boolean simplified;
    private String style;
    public boolean isPrivate;
    private Properties properties;
    private String entityId;
    private String uuid;
}
