package CodeStudio_session03;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Test_CRUDmethods {
	private static final String Contentype = null;

	@Test  
	public void post01() {
		RestAssured.baseURI="https://reqres.in/api/users";
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("name", "Pratixa");
		dataPayload.put("Job", "QA");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(dataPayload.toJSONString());
		Response response = reqSpec.post();
		
		String field = response.jsonPath().get("name");
		System.out.println("field:" + field);
		Assert.assertEquals(field, "Pratixa");
		String resBody = response.getBody().asString();
		System.out.println("resBody:" + resBody);
		Assert.assertEquals(response.statusCode(), 201);
		
	}
	@Test
	public void get02() {
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("Content-type", "application/JSON");
		Response respose = reqSpec.get();
		int statusCode = respose.statusCode();
		Assert.assertEquals(statusCode, 200, "Verify status code");
		Assert.assertEquals(respose.statusLine(), "HTTP/1.1 200 OK");
		String resBody = respose.getBody().prettyPrint();
		System.out.println(resBody);
	}
	@Test
	public void put01() {
		RestAssured.baseURI="https://reqres.in/api/users";
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("name", "Hanuman");
		dataPayload.put("Job", "QA Automation");
		
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(dataPayload.toJSONString());
		Response response = reqSpec.put();
		
		String field = response.jsonPath().get("name");
		System.out.println("field:" + field);
		Assert.assertEquals(field, "Pratixa");
		String resBody = response.getBody().asString();
		System.out.println("resBody:" + resBody);
		Assert.assertEquals(response.statusCode(), 201);
		
	}
	@Test
	public void delete01() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification reqSpec = RestAssured.given();
		Response response = reqSpec.delete();
		Assert.assertEquals(response.statusCode(), 204);
		
	}
}
