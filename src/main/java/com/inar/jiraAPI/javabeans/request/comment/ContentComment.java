package com.inar.jiraAPI.javabeans.request.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentComment {
    private List<ContentItem> content;
    private String type;
}
