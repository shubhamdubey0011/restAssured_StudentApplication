package com.student.test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PoststudentInformation {

	@BeforeClass
	public static void init() {
		RestAssured.basePath = "/student";
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 9090;
	}

	@Test
	public static void createStudentInfo() {
		String[] courses = new String[8];
		courses[0]="adasda";
		courses[1]="asdas";
		courses[2]="asdasd";
		courses[3]="rere";

		Student studentdata = new Student();
		studentdata.setFirstName("adadsasd");
		studentdata.setLastName("asdadsasadsadsads");
		studentdata.setEmail("asdasdads@gmail.com");
		studentdata.setProgramme("_!Courses");
		studentdata.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(studentdata).post().then().statusCode(201);
	}
}
