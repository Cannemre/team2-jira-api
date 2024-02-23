package com.inar.jiraAPI.javabeans.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Body{
	private String type;
	private int version;
	private List<ContentItem> content;
}