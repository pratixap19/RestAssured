package HTTPRequests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod {

	@Test
	public void test06() {
		//delete resource
		RestAssured.baseURI = "https://reqres.in/api/users/573";
		RestAssured.given().
		when().delete().
		then().log().all().statusCode(204);
	}
}
