package CodeStudio_session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static java.util.concurrent.TimeUnit.SECONDS;
public class Test_PostMethod {
	@Test(enabled=false)
	public void test03() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Pratixa");
		jsonData.put("job", "QAAutomation");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		when().post().
		then().log().all().statusCode(201);
	}
	
	//RequestSpecification style
	@Test
	public void test04() {
		System.out.println("Created Post request with RequestSpecification interface");
		
		JSONObject jsonData1 = new JSONObject();
		jsonData1.put("name", "John");
		jsonData1.put("job", "Tester");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.header("Content-Type", "application/json");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonData1.toJSONString());
		Response response = reqSpec.post();
		System.out.println(response.prettyPrint());
	}
}
