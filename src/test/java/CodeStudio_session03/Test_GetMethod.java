package CodeStudio_session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static java.util.concurrent.TimeUnit.SECONDS;


@Test(enabled=false)
public class Test_GetMethod {
	
	public void test01() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println("Response code:" + response.getStatusCode());
		System.out.println("Response body:" + response.getBody().asString());
		System.out.println("Response time:" + response.getTime());
		System.out.println("Response header:" + response.getHeader("Content-Type"));
		
		//validation
		int expectedStatusCode = 200;
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,expectedStatusCode);
	}
	
	//.timeOut(2000)
	
	//Using BDD style
	@Test(enabled=false)
	public void test02() {
		RestAssured.baseURI="https://reqres.in/api/users";
		//RestAssured.get("https://reqres.in/api/users?page=2");
		RestAssured.given()
		.queryParam("page", "2").
		when().get().
		then().statusCode(200);
	}
	
	//RequestSpecification is an interface which modifies request.
	//@Added by Dharmendra: This interface is very helpful for modifying request 
	@Test
	public void test03() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.queryParam("page", "2");
		Response response = reqSpec.get();
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(), 200, "Validate status code");
	}
	

}
