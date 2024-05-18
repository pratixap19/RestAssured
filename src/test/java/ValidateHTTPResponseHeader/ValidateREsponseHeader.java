package ValidateHTTPResponseHeader;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateREsponseHeader {
	@Test
	public void getSingleUser() {
		
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.getHeader("Content-Type");
		System.out.println("Value of content type is : " + contentType);
		
		String connection = response.getHeader("Connection");
		System.out.println("Value of connection is : " + connection);
		
		
		//list of header attribute and value
		Headers headersList = response.getHeaders();
		for(Header header:headersList) {
			System.out.println("Key:" + header.getName() + ":" + "value:" + header.getValue());
		}
		
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
}
