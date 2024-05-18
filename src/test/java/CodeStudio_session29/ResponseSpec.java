package CodeStudio_session29;
//Session# 29 - ResponseSpecification & ResponseSpecBuilder
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {
	
	ResponseSpecification responseSpec = null;
	
	@BeforeClass
	public void createResponseSpec() {
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectStatusLine("HTTP/1.1 200 OK");
		responseBuilder.expectContentType(ContentType.JSON);
		responseBuilder.expectResponseTime(Matchers.lessThan(3000L));
		
		responseSpec = responseBuilder.build();
	}
	
	@Test
	public void getAllbookingIds() {
		
		//BDD style
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking")
		.when()
			.get()
		.then()
			.spec(responseSpec);
			/*.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(3000L));*/
	}
	
	@Test
	public void getAllbookingByFirstName() {
		
		//BDD style
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
		.when()
			.get()
		.then().spec(responseSpec);
			/*.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.contentType(ContentType.JSON)
			.time(Matchers.lessThan(3000L));*/
	}
}
