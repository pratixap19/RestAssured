package CodeStudio_session09;
//bearer token authentication
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationBearerToken {
	
	@Test
	public void bearerToken() {
		//https://gorest.co.in/public/v2/users
		RequestSpecification requestSpec =(RequestSpecification) new RequestSpecBuilder();
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		RestAssured.given();
		JSONObject payload = new JSONObject();//to use JSONObject we have put Json-simple dependency in pom.xml.
		payload.put("name", "Pratixa");
		payload.put("gender", "female");
		payload.put("email", "xyz123@gmail.com");
		payload.put("status", "Active");
		
		//String bearerToken = "09a2fc2f206c0706f3b04c60bc2ef7c6a2909d4aa7b967e66b50ab985c13828b";
		
		String bearerToken = "09a2fc2f206c0706f3b04c60bc2ef7c6a2909d4aa7b967e66b50ab985c13828b";
		requestSpec.headers("Authorization", "Bearer "+bearerToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString()).log().all();
		
		//perform post request
		Response response = requestSpec.post();
		//response.log().all();
		Assert.assertEquals(response.statusCode(), 201, "Verify status code");
		System.out.println("Response status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
		
	}

}
