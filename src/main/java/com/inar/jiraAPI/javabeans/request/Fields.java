package com.inar.jiraAPI.javabeans.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fields{
	private String summary;
	private Issuetype issuetype;
	private Project project;
	private Description description;
	private List<String> labels;
}