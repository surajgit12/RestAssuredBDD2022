package com.qa.user.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class TC004_Delete_User {

	@Test
	public void DeleteUsers() {

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/users/A_nm9U0";

		Response response =

				given()

						.when()
						       .delete()

						.then()
						        .statusCode(200)
						        .statusLine("HTTP/1.1 200 OK")
						        .log().all()
						        .extract().response();

		String Jsonstring = response.asString();
		Assert.assertEquals(Jsonstring.contains(""), true);

	}

}
