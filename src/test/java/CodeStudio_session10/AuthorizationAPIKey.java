package CodeStudio_session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationAPIKey {
	
	@Test
	public void APIKey() {
		//https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.baseUri("https://home.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "delhi").queryParam("appid", "5de7fcf9d7d4a33136608223a0facbbb");
		Response response = requestSpec.get();
		
		Assert.assertEquals(response.statusCode(), 200, "Verify status code");
		System.out.println("Response status line:" + response.statusLine());
		System.out.println("Response status body:" + response.body().asString());
	}
}
