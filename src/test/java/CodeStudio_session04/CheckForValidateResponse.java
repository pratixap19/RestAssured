package CodeStudio_session04;
//validate HTTP response status
//Every request in RestAssure library is represented by an interface called RequestSpecification.
//It allows to modify the request like adding headers and authentication details.
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class CheckForValidateResponse {
	
	@Test(enabled=true)
	public void GetSingleUser() {
		//specify base URI
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		//Get request specification of the request
		 RequestSpecification requestSpec = RestAssured.given();
		 
		 //call get method
		 Response response = requestSpec.get();
		 
		 //get response code
		 int statusCode = response.getStatusCode();
		 
		 //Validate actual status code with expected status code
		 Assert.assertEquals(statusCode, 200, "Incorrect status code received");
		 
		 String statusLine = response.getStatusLine();
		 Assert.assertEquals(statusLine,"HTTP/1.1 200 OK", "Incorrect status line" );
	}
	
		@Test(enabled=false)
		public void getSingleUserUsingValidatableResponse() {
			//specify base URI
			RestAssured.baseURI="https://reqres.in/api/users/2";
			
			//Get request specification of the request
			 RequestSpecification requestSpec = RestAssured.given();
			 
			//call get method
			 Response response = requestSpec.get();
			 
			 ValidatableResponse validateRes = response.then();
			 validateRes.statusCode(200);
			 validateRes.statusLine("HTTP/1.1 200 OK");
		}
		
		@Test(enabled=false)
		public void GetSingleUser_BDDStyle() {//Implemented code with BDD style
			RestAssured.given()
			.when()
				.get("https://reqres.in/api/users/2")
			.then()
				.statusCode(200).statusLine("HTTP/1.1 200 OK");
		}
		
}
