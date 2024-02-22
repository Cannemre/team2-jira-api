package com.inar.jiraAPI.javabeans.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentInformation{

	private String thumbnail;

	private String filename;

	private int size;

	private Author author;

	private String created;

	private String self;

	private String id;

	private String mimeType;

	private String content;
}