package Practice;
//send request and validate response.

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class PracticeDemo_GetMethod {
	
	@Test
	public void getResponse() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users/2");
		Response response = reqSpec.get();
		System.out.println(response.prettyPrint());
		System.out.println("********************************");
		System.out.println("Response time:" + response.getTime());
		System.out.println(response.getHeader("Content-type"));
		Assert.assertEquals(response.statusCode(),200, "Validated response");
		Assert.assertEquals(response.getHeader("Content-type"), "application/json; charset=utf-8");
	}
	
	//BDD style
	@Test
	public void test02() {
			RestAssured.baseURI="https://reqres.in/api/users";
			RestAssured
			.given()
				.queryParam("page", "2")
			.when().get()
			.then().statusCode(200);
		
	}
		

		
}
