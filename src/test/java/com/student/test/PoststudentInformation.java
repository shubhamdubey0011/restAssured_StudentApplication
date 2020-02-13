package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PoststudentInformation {

	@BeforeClass
	public static void init() {
		RestAssured.basePath = "/student";
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
	}

	@Test
	public static void createStudentInfo() {
		String[] courses = new String[8];
		courses[0]="demo1";
		courses[1]="demo2";
		courses[2]="demo3";
		courses[3]="demo4";

		Student studentdata = new Student();
		studentdata.setFirstName("test1");
		studentdata.setLastName("user1");
		studentdata.setEmail("testuser1@example.com");
		studentdata.setProgramme("Courses");
		studentdata.setCourses(courses);

		//given().contentType(ContentType.JSON).when().body(studentdata).post().then().statusCode(201);
		Response response = given().contentType(ContentType.JSON).when().body(studentdata).post();
		System.out.println(response.body().prettyPrint());
	}
}
