package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHTTPResponseHeader {
	@Test
	public void getResponse() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users/2");
		Response response = reqSpec.get();
		System.out.println(response.prettyPrint());
		System.out.println("********************************");
		System.out.println("Response time:" + response.getTime());
		
		//validate single header
		System.out.println(response.getHeader("Content-type"));
		String header = response.getHeader("Content-type");
		Assert.assertEquals(header, "application/json; charset=utf-8");
		
		System.out.println("********************");
		//validate all response header
		Headers headers = response.getHeaders();
		for(Header header1:headers) {
			System.out.println("Key: " + header1.getName() + ":" + header1.getValue());
		}
		
		//Assert.assertEquals(Content-type,"application/json; charset=utf-8");
		
		Assert.assertEquals(response.statusCode(),200, "Validated response");
		Assert.assertEquals(response.getHeader("Content-type"), "application/json; charset=utf-8");
	}

}
