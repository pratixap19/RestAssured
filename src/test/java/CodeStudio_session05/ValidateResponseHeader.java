package CodeStudio_session05;
import org.testng.Assert;
//validate HTTP response header
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseHeader {
	
	@Test
	public void responseHeader() {
		//RestAssured.baseURI="https://reqres.in/api/users/2";
		 RequestSpecification reqSpec = RestAssured.given();
		 reqSpec.baseUri("https://reqres.in");
		 reqSpec.basePath("/api/users/2");
		 
		 //create get request
		 Response response = reqSpec.get();
		 System.out.println(response.prettyPrint());
		 
		 //validate response header
		 String contentType = response.getHeader("Content-Type");
		 System.out.println("vlaue of Content-Type is:" + contentType);
		 
		 Headers headerList = response.getHeaders();
		 for(Header header:headerList) {
			//System.out.println(header);
			  System.out.println( header.getName() + ":" + header.getValue());
		 }
		 
		 //validate header content-type, expected value
		 Assert.assertEquals(contentType, "application/json; charset=utf-8", "Content-Type mismatch");
	}

}
