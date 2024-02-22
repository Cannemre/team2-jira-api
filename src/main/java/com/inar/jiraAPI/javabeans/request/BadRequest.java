package com.inar.jiraAPI.javabeans.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadRequest {
    private String name;
    private String surname;
}
