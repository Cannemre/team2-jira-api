package com.inar.jiraAPI.javabeans.request.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Body{
	private String type;
	private int version;
	private List<ContentComment> content;
}