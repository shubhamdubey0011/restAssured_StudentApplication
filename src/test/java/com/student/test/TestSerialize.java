package com.student.test;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.student.model.Student;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestSerialize 
{
	@Test
 public void verifySerialization()
 {
	  Response response=null;
	  
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
	
	response = RestAssured.given()
            .contentType("application/json")
            .body(studentdata)
            .when().log().all()
            .post("http://localhost:9090/student");
	System.out.println(response.body().prettyPrint());
	
 
        //assertTrue(response.toString().contains("Student added successfully."));
 }
}
