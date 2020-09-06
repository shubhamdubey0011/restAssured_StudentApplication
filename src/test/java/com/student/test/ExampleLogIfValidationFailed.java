package com.student.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port; 	import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ExampleLogIfValidationFailed {

	//static String jsonResponse;

	static void print(Object val) {
		System.out.println("-----------------------------------");
		System.out.println(val);
		System.out.println("-----------------------------------");
	}

	@BeforeClass
	public static void initialize() {

		baseURI = "http://localhost";
		port = 3030;

	}

	@Test
	public static void exampleloggigEveryThing() {
		String jsonResponse = given().when().log().all().get("/products").asString();
		print("Output from method 1");
		print(jsonResponse.toString());
	}
	
	@Test
	public static void exampleOfLoggingResonseBody() {
		print("Output from method 2");
		given().when().get("/products").then().log().body().statusCode(200);
		
	
	}
	@Test
	public static void exampleOfLoggingWithCondition() {
		print("Output from method 3");
		//given().when().get("/products/43900").then().log().ifError();
		//given().when().get("/products/43900").then().log().ifStatusCodeIsEqualTo(400);
		//given().when().get("/products/43900").then().log().ifStatusCodeMatches(greaterThan(200));
		 given().log().ifValidationFails().when().get("/products/4390000").then().statusCode(200));
	}

		
	
	}



