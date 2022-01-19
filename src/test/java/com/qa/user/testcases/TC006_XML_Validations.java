package com.qa.user.testcases;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.Argument;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.Matchers.hasXPath;

import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/*
1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go
4) XPath with text() function
5) Find values using XML Path in XML response 
 */

public class TC006_XML_Validations {

	@Test
	void Single_Content() {

		given()

				.when().get("https://www.w3schools.com/xml/simple.xml")

				.then().body("breakfast_menu.food[0].price", hasItems("$5.95")); // breakfast_menu.food[0].price
		// .log().all();

	}

	@Test
	void Multiple_Content() {

		given()

				.when().get("https://www.w3schools.com/xml/simple.xml")

				.then().body("breakfast_menu.food[0].price", equalTo("$5.95"))
				.body("breakfast_menu.food[0].name", equalTo("Belgian Waffles"))
				.body("breakfast_menu.food[0].calories", equalTo("650"));
		// .log().all();

	}

	@Test
	void All_Content_OneGo() { //text() method is using

		given()

				.when()
				      .get("https://www.w3schools.com/xml/simple.xml")

				.then()
				  .body("breakfast_menu.food[0].text()", equalTo("Belgian Waffles$5.95Two of our famous Belgian Waffles with plenty of real maple syrup650"));

	}
	
	//) find values using XML path in XML response
	
	@Test
	void XML_path_Response() { //text() method is using

		given()

				.when()
				      .get("https://www.w3schools.com/xml/simple.xml")

			
				.then()
				  . body(hasXPath("/breakfast_menu/food/price",containsString("$5.95")));

	}

}


	

	

