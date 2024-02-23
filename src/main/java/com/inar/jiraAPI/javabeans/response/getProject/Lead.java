package com.inar.jiraAPI.javabeans.response.getProject;

import com.inar.jiraAPI.javabeans.response.AvatarUrls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lead {
    private String self;
    private String accountId;
    private AvatarUrls avatarUrls;
    private String displayName;
    private boolean active;
}
