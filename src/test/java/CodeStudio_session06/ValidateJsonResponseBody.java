package CodeStudio_session06;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

//validate Json response body

public class ValidateJsonResponseBody {
	@Test
	public void userListResponseBody() {
		//get requestSpecification reference
		RequestSpecification requestspec = RestAssured.given();
		
		//specify base URI
		requestspec.baseUri("https://reqres.in");
		requestspec.basePath("api/users?page=2");
		
		//create get request
		Response response = requestspec.get();
		
		//validate one field from the nested JSON using jsonPath()
		String nestedValue = response.jsonPath().get("data[0].first_name");
		System.out.println("nestedValue: " + nestedValue);
		
		//read respose body
		 ResponseBody responseBody = response.getBody();
		 /*String responseString = responseBody.asString();
		 
		 //print response body
		 System.out.println("Response body:" + responseString);
		 
		 //check for presence of George in response body
		 Assert.assertEquals(responseString.contains("George"), true, "check for presence of George");*/
		 
		 //get Json path from response body
		 // jsonPath() method will return json path
		 JsonPath jsonPathView = responseBody.jsonPath();
		 
		 //x.data[4].first_name
		 String firstName = jsonPathView.get("data[0].first_name");
		 Assert.assertEquals(firstName, "George", "Check for presence of first name as George");
		 
		 
		 
		 
	
	
	
	}

}
