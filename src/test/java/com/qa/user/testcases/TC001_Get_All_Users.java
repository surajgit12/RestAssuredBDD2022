package com.qa.user.testcases;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsEqual.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;


/*
given()
      Pre-requiste:- set cookies, add auth, add parms, set header info etc.....
when()
      get, post, put, delete....
then()
      validation --> status code,extract response,extract header cookies & response body...
 
 */
public class TC001_Get_All_Users {
	
	
	
	@Test
	 public void getAllUsers() {
		
		given()
		     .when()
		          .get("http://localhost:3000/users")
		      .then()
		           .statusCode(200)
		           .statusLine("HTTP/1.1 200 OK")
		        //  .assertThat().body("first_name", equalTo("Suraj"))
		         //  .assertThat().body(Matchers.equalTo("Suraj"))
		           .assertThat().body("[0].first_name", equalTo("Suraj")) // Import all
		           .headers("Content-Type","application/json; charset=utf-8");
		            
		      
		
	}

}
