package Practice;
import org.json.simple.JSONObject;
//POSt request-creating payload with JsonObject class
//resource info
/*{
	"name":"Prachi",
	"job":"QA"
}*/
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PracticeDemo_PostMethod {
	private static final String Contenttype = null;

	@Test
	public void test01() {
		//BDD style
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Prachi");
		jsonObject.put("job", "QA");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured
		.given().header("Content-type", "application/json")
		.contentType(ContentType.JSON)
		.body(jsonObject.toJSONString())
		.when().post()
		.then().log().all().statusCode(201);
			
	}

}
