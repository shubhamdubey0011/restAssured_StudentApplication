package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

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
		RestAssured.port = 9090;
	}

	@Test
	public static void createStudentInfo() {
		List<String>	courses=new ArrayList<String>();
		courses.add("demo1");
		courses.add("demo3");
		courses.add("demo6");

		Student studentdata = new Student();
		studentdata.setFirstName("test1");
		studentdata.setLastName("user1");
		studentdata.setEmail("testuser11@example.com");
		studentdata.setProgramme("Courses");
		studentdata.setCourses(courses);

		//given().contentType(ContentType.JSON).when().body(studentdata).post().then().statusCode(201);
		Response response = given().contentType(ContentType.JSON).when().body(studentdata).post();
		response.then().statusCode(200);
		System.out.println(response.body().prettyPrint());
	}
}
