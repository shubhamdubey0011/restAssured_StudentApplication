package com.student.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class OrgJsonParsingExample_1 {
	static String json;
	@BeforeClass
	public static void initialize() {
		
		baseURI = "http://localhost";
		port = 3030;
		RestAssured.basePath = "/products";
		json = given().when().log().all().get().asString();

	}
	
	@Test
	public static void demo() {

		JSONObject obj = new JSONObject(json);
		  Object total = obj.get("total");
		 

		System.out.println("total count is "+total);

		JSONArray arr = obj.getJSONArray("data");
		for (int i = 1; i < arr.length()-1; i++) {
			 JSONObject post_id = (JSONObject) arr.get(i);
			 JSONArray categories = (JSONArray) post_id.get("categories");
			
			for (Object object : categories) {
				 System.out.println();
				System.out.println("All the Categories :"+object);
			}
		}

	}
}
