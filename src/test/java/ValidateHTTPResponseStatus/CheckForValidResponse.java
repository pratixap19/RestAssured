package ValidateHTTPResponseStatus;
import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

//Response contains
//1. response status code
//2. response body
//3. response header

//validate response status
// -status code
// -error status code
// -response status line which contains protocol status code string i.e HTTP/1.1 200 ok"
public class CheckForValidResponse {

	@Test(enabled = false)
	public void GetSingleUser() {
		// specify base url
		baseURI = "https://reqres.in/api/users/2";

		// Every request in Rest assured library is represented by an interface called
		// RequestSpecification.
		// It allows to modify the request, like adding headers or adding authentication
		// details.
		RequestSpecification requestSpec =  given();

		// call get method
		Response response = requestSpec.get();

		// get response code
		int statusCode = response.getStatusCode();

		// validate actual and expected response code
		Assert.assertEquals(statusCode, 200);

		String statusLine = response.getStatusLine();
		// Assert.assertEquals(statusLine, "HTTP/1.1 200 ok");
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ok", "Incorrect status line returned");
	}

	@Test(enabled = false)
	public void GetSingleUserUsingValidatebleRespose() {
		// specify base url
		baseURI = "https://reqres.in/api/users/2";

		// Every request in Rest assured library is represented by an interface called
		// RequestSpecification.
		// It allows to modify the request, like adding headers or adding authentication
		// details.

		RequestSpecification requestSpec = given();

		// call get method
		Response response = requestSpec.get();

		ValidatableResponse validateRes = response.then();

		validateRes.statusCode(200);

		validateRes.statusLine("HTTP/1.1 200 ok");

	}
	
	//method with BDD style
	@Test
	public void getSingleUser_BDDStyle() {
		 given()
		.when()
			.get("https://reqres.in/api/users/2")	
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
	}
}
