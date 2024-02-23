package com.inar.jiraAPI.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContentItem{
	private String type;
	private List<ContentItem> content;
	private String text;
}