package CodeStudio_session07;
//how to work with query parameters
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class QueryParameter {
	@Test
	public void filterData() {
		
		//get request specification for the given request
		 RequestSpecification requestSpec = RestAssured.given();
		 requestSpec.baseUri("https://reqres.in");
		 requestSpec.basePath("api/users?page=2");
		 requestSpec.queryParam("page", 2).queryParam("id", 10);
		 
		 //perform get request
		 Response response = requestSpec.get();
		 String responseBodyString = response.getBody().asString();
		 System.out.println("Response body:" + responseBodyString);
		 
		 //get json path view of response body
		 JsonPath jsonPathView = response.jsonPath();
		 
		 //get first name
		 String firstName = jsonPathView.get("data.first_name");
		 
		 Assert.assertEquals(firstName, "Byron", "Verify first name");
		
	}
}
