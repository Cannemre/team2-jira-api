package com.inar.jiraAPI.javabeans.request.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentItem{
	private String type;
	private String text;
}