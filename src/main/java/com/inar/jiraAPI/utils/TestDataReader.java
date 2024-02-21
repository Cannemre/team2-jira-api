package com.inar.jiraAPI.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestDataReader {

    static ObjectMapper mapper = new ObjectMapper();
    static FileInputStream fileInputStream;

    public static <T> T readData(String path, Class<T> valueType) throws IOException {
        try {
            fileInputStream = new FileInputStream("workspace/team2-jira-api/src/test/resources/test_data/" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return mapper.readValue(fileInputStream, valueType);
    }
    public static <T> List<T> readDataList(String path, Class<T> valueType) throws IOException {
        try {
            fileInputStream = new FileInputStream("workspace/team2-jira-api/src/test/resources/test_data/" + path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return mapper.readValue(fileInputStream, new TypeReference<>() {
        });
    }
}
