package CodeStudio_session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test_DeleteMethod {
	@Test(enabled=false)
	public void test05() {
		RestAssured.baseURI="https://reqres.in/api/users/90";
		RestAssured.given().
		when().delete().
		then().statusCode(204).log().all();
	}
	
	@Test
	public void test06() {
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users/90");
		Response response = reqSpec.delete();
		Assert.assertEquals(response.statusCode(), 204);
		
	}

}
