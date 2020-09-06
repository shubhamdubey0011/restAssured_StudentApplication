package com.student.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestDeserialize {

	@BeforeClass
	public static void init() {
		RestAssured.basePath = "/student";
		RestAssured.baseURI = "http://localhost/";
		RestAssured.port = 9090;
	}

	@Test
	public void verifyDersialization() {
		Student studentdata = RestAssured.given().when().log().all().get("95").as(Student.class);
		System.out.println(studentdata.toString());
	}
}
