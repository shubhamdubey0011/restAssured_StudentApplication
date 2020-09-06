package com.student.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathParamExamples {
	
	
@Test
public static void usePathParam()
{
	Response response = given()
	.pathParam("id", "2").log().all()
	.when()
	.get("http://localhost:9090/student/{id}");
	
	
	response.prettyPrint();

	
	
}
}
