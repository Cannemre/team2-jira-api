package com.inar.jiraAPI.javabeans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRoles {
    private int size;
    private List<Object> items;
}