package com.inar.jiraAPI.javabeans.request.createissue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentItem{
	private String type;
	private List<ContentInner> content;
}