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

public class videoGamewithSerializableXML {
	
	
	@Test(priority =1)
	public void testVideoGameSerializationJSON() {
		
		
		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setId(11);
		myVideoGame.setName("august");
		myVideoGame.setReleaseDate("2020-05-16");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Swimming");
		myVideoGame.setRating("Six");
		
		
		given()
		      .contentType("application/XML")
		      .body(myVideoGame)
		      
		.when()     
		       .post("http://localhost:8080/app/videogames")
		.then()
		       .log().all()
		       .body(equalTo("{status" + " :"+"Record Added Successfully}"));
		      // .body(equalTo{"status": "Record Added Successfully"})
		     //  .body(equalTo("{\"status\" : \"Record Added Successfully\"}"))
		
	}
    
	@Test(priority =2)
	public void testVideoGameDeSerializationJSON(){
		
		VideoGame myVideoGame = get("http://localhost:8080/app/videogames/10").as(VideoGame.class);
		System.out.println(myVideoGame.getVideoGamesData());
		
	}
}
