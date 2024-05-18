package CodeStudio_session08;
//basic authentication and digest authentication
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization {
	@Test(enabled=false)
	public void basicAuth() {
		
		 RequestSpecification requestSpec = RestAssured.given();
		 requestSpec.baseUri("http://postman-echo.com");
		 requestSpec.basePath("/basic-auth");
		 
		 //below line of code will return status:HTTP/1.1 401 Unauthorized so basic authorization is used as below.
		 //Response response = requestSpec.get(); 
		 
		 Response response = requestSpec.auth().basic("postman", "password").get();
		//Print status line
		 System.out.println("Basic auth response status:" + response.statusLine());
		 System.out.println("Basic auth response body:" + response.body().asString());
	}
	@Test
	public void digestAuth() {
		 //http://httpbin.org/digest-auth/undefined/pratixa/pratixa
		 RequestSpecification requestSpec = RestAssured.given();
		 requestSpec.baseUri("http://httpbin.org");
		 requestSpec.basePath("/digest-auth/undefined/pratixa/pratixa");
		 
		 //below line of code will return status:HTTP/1.1 401 Unauthorized so basic authorization is used as below.
		 //Response response = requestSpec.get();  
		 Response response = requestSpec.auth().digest("pratixa", "pratixa").get();
		 Assert.assertEquals(response.statusCode(), 200, "Check for status code");
		 
		 //Print status line
		 System.out.println("Digest auth response status:" + response.statusLine());
		 System.out.println("Digest auth response body:" + response.body().asString());
	}

}
