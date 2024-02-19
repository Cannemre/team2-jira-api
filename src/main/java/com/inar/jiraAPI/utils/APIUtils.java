package com.inar.jiraAPI.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIUtils {

    public static Response sendGetRequest(RequestSpecification request, String url){
        return request
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(RequestSpecification request, String url, Map<String,String> queryParams){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(RequestSpecification request, String url, Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(RequestSpecification request, String url, String[] pathParams){
        return request
                .contentType(ContentType.JSON)
                .pathParam(pathParams[0],pathParams[1])
                .when()
                .get(url +"/{" + pathParams[0] +"}")
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(RequestSpecification request, String url, Map<String,String> queryParams){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(RequestSpecification request, String url, Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(RequestSpecification request, String url, Map<String,String> queryParams,Object payload){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .body(payload)
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(RequestSpecification request, String url, String[] pathParams,Object payload){
        return request
                .contentType(ContentType.JSON)
                .pathParam(pathParams[0],pathParams[1])
                .when()
                .body(payload)
                .post(url + "/{" + pathParams[0] + "}")
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(RequestSpecification request, String url){
        return request
                .contentType(ContentType.JSON)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPutRequest(RequestSpecification request, String url,Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPutRequest(RequestSpecification request, String url,Object payload,Map<String,String> queryParams) {
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .queryParams(queryParams)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(RequestSpecification request, String url,Object payload,Object[] pathParameters) {
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam(String.valueOf(pathParameters[0]),String.valueOf(pathParameters[1]))
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(RequestSpecification request, String url,Object[] pathParameters) {
        return request
                .contentType(ContentType.JSON)
                .pathParam(String.valueOf(pathParameters[0]),String.valueOf(pathParameters[1]))
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(RequestSpecification request, String url,Object payload,Map<String,String> queryParams,String[] pathParameters) {
        return request
                .pathParam(pathParameters[0],pathParameters[1])
                .contentType(ContentType.JSON)
                .body(payload)
                .queryParams(queryParams)
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }
}
