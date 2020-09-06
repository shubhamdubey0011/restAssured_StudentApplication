package com.student.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;

public class GsonParsingExample {
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

		@SuppressWarnings("deprecation")
		JsonObject jsonobject = new JsonParser().parse(jsonResponse).getAsJsonObject();
		System.out.println(jsonobject.get("name"));
		System.out.println(jsonobject.getAsJsonArray("categories").get(2));
		//JsonArray categories = jsonobject.getAsJsonArray("categories");
		
		
		
	
	
	
}
}
