package HTTPRequests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

//given - all input details
//when - submit the API
//then - validate the response
public class Test_PostMethod {
	@Test
	public void test03() {
		//create Json object to create resource
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Pratixa");
		jsonData.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
	}

}
