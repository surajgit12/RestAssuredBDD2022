package SerializtionsAndDeserialization;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.Matchers.hasXPath;

import java.util.ArrayList;

public class With_SerializationAndDeserialization {
	
	
	// post request serialization
	
	@Test
	void createNewSerialization() {
		
		ArrayList<String> coursesList =new ArrayList<String>();
		
		coursesList.add("API");
		coursesList.add("RestAssured");
		
		student std = new student();
		std.setId(114);
		std.setFirstName("Luz");
		std.setLastName("Kames");
		std.setEmail("luz@c.com");
		std.setProgramme("product");
		std.setCourses(coursesList);
		
		given()
		      .contentType(ContentType.JSON)
		      .body(std)
		.when()
		       .post("http://localhost:8085/student")
		.then()
		       .statusCode(201)
		       .assertThat()
		       .body("msg", equalTo("Student added"));
		
	}
	
	// get request de-serialization
	
	 @Test
	 public void getStudentDeserialization() {
		 
		 
		 student std = get("http://localhost:8085/student/114").as(student.class);
		 
		 Assert.assertEquals(std.getFirstName(), "Luz");
		 
		 std.getStudentRecord();
				        
				  
		
	}

}
