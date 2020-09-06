package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.student.model.Student;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewStudentWithPojo {

	@BeforeClass
	public static void init() {
		RestAssured.basePath = "/student";
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
	}

	@Test
	public static void createStudentInfo() {

		Faker fkdata = new Faker();
		
		List<String> courses = new ArrayList<String>();
		Student studentdata = new Student();
		courses.add("demo1");
		courses.add("demo3");
		courses.add("demo6");

		studentdata.setFirstName(fkdata.name().firstName());
		studentdata.setLastName(fkdata.name().lastName());
		studentdata.setEmail(fkdata.name().lastName()+fkdata.name().firstName()+"@"+"mallinator");
		studentdata.setProgramme("Courses");
		studentdata.setCourses(courses);

		// given().contentType(ContentType.JSON).when().body(studentdata).post().then().statusCode(201);
		Response response = given().contentType(ContentType.JSON).when().log().all().body(studentdata).post();
		System.out.println(response.body().prettyPrint());
		response.then().statusCode(201);
	}
}
