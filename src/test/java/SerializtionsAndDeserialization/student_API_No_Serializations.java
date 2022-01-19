package SerializtionsAndDeserialization;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.Matchers.hasXPath;

/*
 * {
      		  "id": 101,
      		  "firstName": "xxxxxx",
       		 "lastName": "xxxxxx",
       		 "email": "abcxyz@risusDonecegestas.edu",
       		 "programme": "Manger",
       		 "courses": [
        			    "Java",
        			    "Selenium"
        		   ]
    		}
 * 
 */

public class student_API_No_Serializations {

	public HashMap map = new HashMap();

	@Test(priority =1)
	public void createNewStudent() {
		map.put("id", 112); /// If the script gets failed the id automatically generated
		map.put("firstName", "Jeevan");
		map.put("lastName", "Rapat");
		map.put("email", "jeevan@h.com");
		map.put("programme", "QA Engg");

		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("JAVA");
		coursesList.add("Selenium");
		
		map.put("courses", coursesList);
		
		
		given()
		    .contentType( "application/json") // "application/json"
		    .body(map)
		
		.when()
		      .post("http://localhost:8085/student")
		      
		 .then()
		       .statusCode(201)
		       .assertThat()
		       .body("msg", equalTo("Student added"));

     }
	
	// Get Request to retrive student details
	
	@Test(priority =2)
	void studentRecords() {
		
	         given()
	         
	            .when()
	                  .get("http://localhost:8085/student/112")
	            .then()
	                   .statusCode(200)
	                   .assertThat()
	                   .body("id",equalTo(112))
	                   .log().all();
		
	}
	
	
}