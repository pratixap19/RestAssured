package HTTPRequests;

import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class FirstGetRequest {
	
	@Test
	public void testCase01() {
		Response response = get("https://reqres.in/api/users/2");
		System.out.println("Response : " + response.asString());
		System.out.println("Status code : " + response.getStatusCode());
		System.out.println("Response body : " + response.getBody().asString());
		System.out.println("REsponse time : " + response.getTime());
		System.out.println("Response header : " + response.getHeader("Content-Type"));
		
		//validate status code
		//expected status code = 200
			
		 int expectedStatusCode = 200;
		 int actualStatuscode = response.getStatusCode();
		 Assert.assertEquals(expectedStatusCode,actualStatuscode);
	}
	
	@Test
	public void test02() {
		//given, when, then
		baseURI = "https://reqres.in/api/users";
		given().queryParam("page", "2")
		.when().get()
		.then().statusCode(200);
		
	}
	
	
}
