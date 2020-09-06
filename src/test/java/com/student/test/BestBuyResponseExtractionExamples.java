package com.student.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import static io.restassured.RestAssured.*;

public class BestBuyResponseExtractionExamples {

	 static String jsonResponse;

	    static void print(String val){
	        System.out.println("-----------------------------------");
	        System.out.println(val);
	        System.out.println("-----------------------------------");
	    }

	   @BeforeClass
	    public static void initialize(){

	        baseURI = "http://localhost";
	     port = 3030;
	        
	        jsonResponse = given().when().get("/products").asString();

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


	    @Test(description ="Get the root element" )
	    public void getRoot(){
	    	
	    	Map<String,?> rootElement = JsonPath.read(jsonResponse, "$");
	    	print(rootElement.toString());
	    }

	    
	    @Test(description="Get the total value from the response")
	    public void getTotalFromResponse(){
	    
	    	int totalValue = JsonPath.read(jsonResponse, "$.total");
	    	print(totalValue + "");
	       
	    }

	    
	    @Test(description="Get all the data elements")
	    public void getAllDataElements(){

	    	List<HashMap<String,Object>>  dataElements= JsonPath.read(jsonResponse, "$.data");
	    	dataElements.stream().forEach(System.out::println);
	    }

	    
	    @Test(description="Get firstDataElement")
	    public void getFirstDataElement(){
	    	
	    	Map<String,?> firstDataElement = JsonPath.read(jsonResponse, "$.data[0]");
	    	print(firstDataElement.toString());

	    }

	    
	    @Test(description="Get lastDataElement")
	    public void getLastDataElement(){
	    	
	    	Map<String,?> lastDataElement = JsonPath.read(jsonResponse, "$.data[-1]");
	    	print(lastDataElement.toString());

	    }

	   
	    @Test(description="Get all the ids in data")
	    public void getAllIdsUnderData(){
	    	
	    	List<String> lastDataElement = JsonPath.read(jsonResponse, "$.data[*].id");
	    	print(lastDataElement.toString());

	    }

	   
	    @Test(description="Get All the Ids")
	    public void getAllIds(){
	    	
	    	List<String> allIds = JsonPath.read(jsonResponse, "$..[*].id");
	    	print(allIds.toString());

	   
	    }

	    @Test(description="Get The name of the products whose price is less than ")
	    public void getNameOfProductsWhosePriceisLessThan5(){

	    	List<String> names = JsonPath.read(jsonResponse, "$.data[?(@.price>5)].name");
	    	
	    	names.stream().forEach(System.out::println);
	    }
}
