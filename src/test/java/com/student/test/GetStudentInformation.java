package com.student.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matcher.*;
import static io.restassured.RestAssured.*;

public class GetStudentInformation {

	
	@BeforeClass
	public static void init()
	{
		RestAssured.basePath="/student";
		RestAssured.baseURI="http://localhost";
		RestAssured.port=9090;
	}
	@Test
	public static void getstudentAllInformation()
	{
		Response response = given().when().get("/list");
		//response.body().prettyPrint();
		response.then().statusCode(200);
	}
	@Test
	public static void getStudentInfo()
	{
		Response response = given().when().get("/1");
		//response.body().prettyPrint();
		response.then().statusCode(200);
	}
	@Test
	public static void getFilteredStudentInfo()
	{
		Response response = given().param("programme", "Mechanical Engineering").param("limit", "5").when().get("/list");
		response.body().prettyPeek();
		response.then().statusCode(200);
	}
	
}
