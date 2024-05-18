package CodeStudio_session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//toJSONString()- It will convert java code to JSON Object
public class Test_PatchMethod {
	@Test
	public void test04() {
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Pahal");
		jsonData.put("job", "Tester");
		
		RestAssured.baseURI="https://reqres.in/api/users/90";
		RestAssured.given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().patch().
		then().statusCode(200).log().all();
	}

}
