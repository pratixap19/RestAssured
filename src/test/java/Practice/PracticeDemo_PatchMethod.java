package Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PracticeDemo_PatchMethod {
	@Test
	public void test01() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Parimal");
		jsonObject.put("job", "Dev");
		
		RestAssured.baseURI="https://reqres.in/api/users/661";
		RestAssured
		.given()
			.header("Content-type", "application/json").contentType(ContentType.JSON)
			.body(jsonObject.toString())
		.when().patch()
		.then().log().all().statusCode(200);
	}
}
