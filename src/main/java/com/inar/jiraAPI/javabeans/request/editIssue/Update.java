package com.inar.jiraAPI.javabeans.request.editIssue;

import com.inar.jiraAPI.javabeans.request.editIssue.SummaryItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Update {

    private List<SummaryItem> summary;

    private List<Object> labels;
}