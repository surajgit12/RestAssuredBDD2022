package com.qa.user.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.testUtils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class TC003_Put_Users  {
	
	public static HashMap map =new HashMap();
	
	String firstName = RestUtils.get_first_name();
	String lastname = RestUtils.get_last_name();
	String subjectID = RestUtils.get_SubjectID();
	
	int id = 409;
	
	@BeforeClass
	public void updateUsers() {
		
		
        map.put("first_name", firstName);
        map.put("last_name", lastname);
        map.put("subjectId", subjectID);
        
    	RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/users/"+id;
		
	}
	  @Test
	  void updateUsersDB() {
		  
		
		  
		  given()
		         .contentType("application/json")
		         .body(map)
		  
		  .when()
		         .put()
		  
		  .then()
		        .statusCode(200)
		        .log().all();
		     
		  
		  
		
	}

}
