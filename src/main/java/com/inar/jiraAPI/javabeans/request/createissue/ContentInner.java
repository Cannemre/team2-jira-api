package com.inar.jiraAPI.javabeans.request.createissue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentInner {
    private String text;
    private String type;

}
