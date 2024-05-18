package CodeStudio_session02;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstGetRequest {
	@Test
	public void testcase01() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println("Status code:" + res.getStatusCode());
		System.out.println("Response body:" + res.getBody().asPrettyString());
		System.out.println("Response time:" + res.getTime());
		System.out.println("Reponse header:" + res.getHeader("Content-type"));
		
		int expectedStatusCode=200;
		int actualStatusCode = res.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
	//BDD style
	@Test(enabled=false)
	public void testcase02() {
		//given,when,then
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.
		given().queryParam("page", 2).
		when().get().
		then().statusCode(200).log().all();
	}
}
