package CodeStudio_session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Deserialization {
	@Test
	public void createUser() {
		//create request specification
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://reqres.in/");
		reqSpec.basePath("/api/users");
		
		//create request body
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Pratixa");
		jsonData.put("job", "QA");
		
		//perform post request
		Response response = reqSpec.
		contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		post();
		
		//create object of response body
		ResponseBody responseBody = response.getBody();//this is json data
		
		//deserialize responseBody i.e json response body to class object
		//Class<T>is a generic form of any class of type T which is also referred to as template class.
		//as() will create instance of JSONPostRequestResponse class
		//below step will work for deserialization i.e converting Json data to object data
		//as() method will create instance of java class i.e JSONPostRequestResponse
		JSONPostRequestResponse responseClass = responseBody.as(JSONPostRequestResponse.class);
		
		Assert.assertEquals(responseClass.name, "Pratixa", "Check for name");
		Assert.assertEquals(responseClass.job, "QA", "Check for job");
		
		
		
		
		
		
		
	}
}
