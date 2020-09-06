package com.student.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OrgJsonParsingExample {
	
	static String jsonResponse;

	@BeforeClass
	public static void initialize() {

		baseURI = "http://localhost";
		port = 3030;
		RestAssured.basePath = "/products";
		jsonResponse = given().when().log().all().get("/43900").asString();

	}
	
	@Test(description = "Get the root element")
	public void getRoot() {

		JSONObject obj = new JSONObject(jsonResponse);
	Object pageName = obj.get("id");
	
		 System.out.println("*************"+pageName);
		 
		 
		 JSONArray categoriesArray = obj.getJSONArray("categories");
		 for (Object object : categoriesArray) {
			System.out.println(object.toString());
		}
		 
	}
	
	
}