package com.student.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;

public class Jayway_JsonparserExample {
	static String jsonResponse;

	@BeforeClass
	public static void initialize() {

		baseURI = "http://localhost";
		port = 3030;
		RestAssured.basePath = "/products";
		jsonResponse = given().when().get("/43900").asString();

	}

	static void print(String val) {
		System.out.println("-----------------------------------");
		System.out.println(val);
		System.out.println("-----------------------------------");
	}

	@BeforeMethod
	void printToConsole() {
		System.out.println("-----Starting the test method--------");
		System.out.println("   ");
	}

	@AfterMethod
	void printToConsoleAgain() {
		System.out.println("-----Ending the test method--------");
		System.out.println("   ");
	}

	@Test(description = "Get the root element")
	public Map<?, ?> getRoot() {

		Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");
		//print(rootElement.toString());
		return rootElement;
	}

	@Test(description = "Get the name of the product")
	public void getNameOfProduct() {

		String productName = JsonPath.read(jsonResponse, "$.name");
		print(productName + "");

	}

	@Test(description = "Get all the categories available")
	public void getAllDataElements() {

		List<HashMap<String, Object>> dataElements = JsonPath.read(jsonResponse, "$.categories");
		dataElements.stream().forEach(System.out::println);
	}

	@Test(description = "Get first element from the  categories available")
	public void getFirstDataElements() {

		Map<String,?> dataElements = JsonPath.read(jsonResponse, "$.categories[0]");
		print(dataElements.toString());
	}

	@Test(description = "Get last element from the the categories available")
	public void getAlllastElements() {

		Map<String,?> dataElements = JsonPath.read(jsonResponse, "$.categories[-1]");
		print(dataElements.toString());
		
	}
	
	   
    @Test(description="Get all the ids in data")
    public void getAllIdsUnderData(){
    	List<String> dataElements = JsonPath.read(jsonResponse, "$..[*].name");
    	print(dataElements.toString());
    	
    }
    


}
