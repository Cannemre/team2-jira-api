package com.inar.jiraAPI.javabeans.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author{

	private String accountId;

	private String emailAddress;

	private String displayName;

	private String accountType;

	private AvatarUrls avatarUrls;

	private String self;

	private boolean active;

	private String timeZone;
}