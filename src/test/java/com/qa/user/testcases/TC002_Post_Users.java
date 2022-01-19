package com.qa.user.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.testUtils.RestUtils;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class TC002_Post_Users  {
	
	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void post_user() {
		
		map.put("first_name", RestUtils.get_first_name());
		map.put("last_name", RestUtils.get_last_name());
		map.put("id", RestUtils.get_id());
		map.put("subjectId", RestUtils.get_SubjectID());
		
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/users";
		
	}
	
	@Test
	void createUsers() {
		
		given()
		      .contentType("application/json")
		      .body(map)
		      .and()
		      
		      .when()
		            .post()
		            
		      .then()
		            .statusCode(201);
		     
	}

}
