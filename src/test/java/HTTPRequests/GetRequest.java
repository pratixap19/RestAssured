package HTTPRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class GetRequest {
	@Test	
	public void test01() {
	
		baseURI = "https://reqres.in";
		Response response =
         given()
		.when().get("api/users/2")
		.then().log().all().extract().response();
		
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, 200);
		 System.out.println("statusCode : " + statusCode);
		 String responseBody = response.getBody().asString();
		 System.out.println("responseBody" + responseBody);
		 
		 JsonPath jp = new JsonPath(responseBody);
		 String name = jp.get("data.first_name");
		 System.out.println("name :" + name);
		 
		  int id = jp.getInt("data.id");
		  System.out.println("id : " + id);
		 
	}
}
