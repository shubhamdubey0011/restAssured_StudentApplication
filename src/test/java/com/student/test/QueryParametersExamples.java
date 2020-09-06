package com.student.test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class QueryParametersExamples {

	@Test
	public static void demoQueryParamsExample() {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("programme", "Computer Science");
		params.put("limit", "1");

		Response response = (Response) given()
				// .queryParam("programme", "Computer Science")
				// .queryParam("limit", "1")
				// .queryParameters("programme", "Computer Science", "limit", "1")
				.queryParameters(params)
				.when().log().all().get("http://localhost:9090/student/list");

		response.prettyPrint();
		response.then().statusCode(200);

	}
}
