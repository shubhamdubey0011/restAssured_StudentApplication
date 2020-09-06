package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class restAssuredJsonParserExample {

	static Response jsonResponse;

	public static void main(String[] args) {

		jsonResponse = doGetRequest("https://jsonplaceholder.typicode.com/users");

		// print count or number entries in response
		List<String> noOfItems = jsonResponse.jsonPath().getList("$");
		System.out.println(noOfItems.size());

		// Print UserName
		String usernames = jsonResponse.jsonPath().getString("username");
		System.out.println(usernames);

		// Print UserName
		String firstUsernames = jsonResponse.jsonPath().getString("username[0]");
		System.out.println(firstUsernames);
		
		//fetching Username using list<String>
		List<?> usersList = jsonResponse.jsonPath().getList("username");
		System.out.println(usersList.get(4));
		
		//fetching list of map or hashmaps(all the company details)
		List<HashMap<String, Object>> mapCompanyDetails = jsonResponse.jsonPath().getList("company");
		System.out.println(mapCompanyDetails.get(0).get("name"));
		mapCompanyDetails.stream().forEach(System.out::println);
		mapCompanyDetails.stream().forEach(s->System.out.println("Map available"+s));
		
		
		
	}

	public static Response doGetRequest(String Url) {
		RestAssured.defaultParser = Parser.JSON;
		return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().log().all().get(Url)
				.then().contentType(ContentType.JSON).extract().response();

	}

}
