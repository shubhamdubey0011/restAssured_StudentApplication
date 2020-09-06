package com.student.test;

import javax.management.DescriptorKey;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RestAssuredStyleDemo {

	//@Test(description = "get student data in restAssure style")
	public static void getStudentDataRestAssuredStyle() {
		/*
		 * Use the RestAssured class to generate a RequestSpecification for the "URL"
		 * Specify the HTTP Method type Send the Request to the Server Get the Response
		 * back from the server Print the returned Response’s Body
		 */
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:9090/student/list");
		ValidatableResponse validateResponse = response.then();
		validateResponse.statusCode(200);
		response.prettyPrint();
	}

	
	/* BDD Style */
	@Test(description = "get student data in bdd Style")
	public static void getStudentDatabddStyle() {

		given().when().log().all().get("http://localhost:9090/student/list").then().statusCode(200);
	}

	//@Test(description = "get student data in bdd Style using ex[ect")
	public static void getStudentDataBddStyleExpect() {

		given().expect().statusCode(200).when().get("http://localhost:9090/student/list").then().statusCode(200);
	}
}
