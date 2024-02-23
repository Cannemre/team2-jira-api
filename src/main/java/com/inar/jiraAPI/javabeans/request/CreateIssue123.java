package com.inar.jiraAPI.javabeans.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CreateIssue123 {
	private Fields fields;
	@Data
	@NoArgsConstructor
	@AllArgsConstructor

	public static class Fields{
		private String summary;
		private Issuetype issuetype;
		private Project project;
		private Description description;
		private List<String> labels;
		private List<Content> content;

		@Data
		@NoArgsConstructor
		@AllArgsConstructor

		public static class Issuetype{
			private String name;
		}
		@Data
		@NoArgsConstructor
		@AllArgsConstructor

		public static class Project{
			private String key;
		}
		@Data
		@NoArgsConstructor
		@AllArgsConstructor

		public static class Description{
			private String type;
			private int version;
			private List<Content> content;
		}
		@Data
		@NoArgsConstructor
		@AllArgsConstructor

		public static class Content {
			private String type;
			private List<ContentItem> content;
			@Data
			@NoArgsConstructor
			@AllArgsConstructor


			public static class ContentItem {
				private String type;
				private String text;
			}
		}

	}
}