package com.qa.user.testcases;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/*
1) Test Status Code
2) Log Response
3) Verifying Single content in Response body
4) Verifying Multiple content in Response body
5) Setting Parmeters & Headers
 
 */

public class TC005_Basic_Validation {

	@Test(priority = 1)
	public void test_Status_Code() {

		given()

				.when().get("http://localhost:3000/users/3")

				.then().statusCode(200).log().all();

	}

	@Test(priority = 2)
	public void checkLogs() {

		given()

				.when().get("http://localhost:3000/users/5")

				.then().statusCode(200).log().all();

	}

	@Test(priority=3)
	public void Single_Contents() {

		given()

				.when().get("http://localhost:3000/users")

				.then().statusCode(200)
				.body("[4].first_name", equalTo("Global"));

	}
	
	@Test(priority=4)
	 public void multiple_Content() {
		
		given()
		
		.when().get("http://localhost:3000/users")
		
		.then()
		       .body("first_name", hasItems("Global","Suraj"));
		 
	 }
	
	
	
    @Test
	void parameters_headers(){
	
	
	given().formParams("username", "john","password","1234")
	       .param("myname","Test")
	       .header("myheader","Indian")

	.when().get("http://localhost:3000/users")

	.then().statusCode(200)
	.log().all();
	
}
}


