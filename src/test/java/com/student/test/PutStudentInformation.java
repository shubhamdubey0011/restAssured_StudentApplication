package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutStudentInformation {

	@BeforeClass
	public static void init() {
		RestAssured.basePath = "/student";
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
	}

	@Test
	public static void createStudentInfo() {
		//String[] courses = new String[8];
		List<String> courses = new ArrayList<String>();
		courses.add("demo1");
		courses.add("demo3");
		courses.add("demo6");

		Student studentdata = new Student();
		studentdata.setFirstName("Shubham");
		studentdata.setLastName("Dubey");
		studentdata.setEmail("Shubhamdubey0011@gmail.com");
		studentdata.setProgramme("QA_Courses");
		studentdata.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(studentdata).put().then().statusCode(201);
	}
}
