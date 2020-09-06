package com.student.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

/**
 * @author sdubey6447
 * 
 * BDD style approach 
 *
 */
public class CreateNewStudentPostExample {
	
	
	
	
@Test
public static void createNewUser()
{
	RestAssured.basePath = "/student";
	RestAssured.baseURI = "http://localhost";
	RestAssured.port = 9090;

	String Payload="{\"firstName\":\"Ryuth\",\"lastName\":\"langmore\",\"email\":\"Ryuth.langmore@anuncInc.edu\",\"programme\":\"Mechanical Engineering\",\"courses\":[\"Machine Learning\",\"Engineering Analysis II\"]}";
	
    given()
    .when().log().all(true)
    .contentType(ContentType.JSON)
    .body(Payload).post()
    .then()
    .statusCode(201);
}

}
