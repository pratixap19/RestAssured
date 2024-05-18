package CodeStudio_session28;
//Session# 28 - How To Add Header In Request
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderInRequest {
	@Test	
	public void testMethod1() {
		//first approach of adding header in request: adding headers with Map interface
		Map<String, String> requestHeader = new HashMap<>();
		requestHeader.put("Header1", "Value1");
		requestHeader.put("Header2", "Value2");
		
		//second approach of adding header in request: by creating object of Header class
		Header requestHeaderObj = new Header("Header1","Value1");
		
		//third approach of adding header in request:by creating list with List interface
		Header header1 = new Header("Header1","Value1");
		Header header2 = new Header("Header2","Value2");
		Header header3 = new Header("Header3","Value3");
		
		List<Header> headerList = new ArrayList<Header>();
		headerList.add(header1);
		headerList.add(header2);
		headerList.add(header3);

		Headers headersObj = new Headers(headerList);

		RequestSpecification requestSpec = RestAssured.given();
		requestSpec.header("Header1","Value1");
		//requestSpec.headers(requestHeader);
		requestSpec.headers(headersObj);
		requestSpec.log().headers();
		//specify url
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		//perform get request
		Response resopnse = requestSpec.get();
		//validate response code
		Assert.assertEquals(resopnse.statusCode(), 200);
		
		//BDD Style (Given, when ,then)
		
				/*RestAssured
				.given()
					.headers(headersObj)
					.log().headers()
				.when()
					.get("https://reqres.in/api/users?page=1")
				.then()
					.log().body();*/
		}
}
