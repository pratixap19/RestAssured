package CodeStudio_session13;
//How to retrive/query request specification
//Followed CodeStudio
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryRequestSpecification {
	@Test
	public void createUser() {
		
		//create json data
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Pratixa");
		jsonData.put("job", "QA");
		
		//create request
		 RequestSpecification reqSpec = RestAssured.given();
		//specify URL
		 reqSpec.baseUri("https://reqres.in");
		 reqSpec.basePath("/api/users");
		 reqSpec.contentType(ContentType.JSON).header("header name", "header value").body(jsonData.toJSONString());
		
		 //query details from request specification
		 QueryableRequestSpecification queryRequest = SpecificationQuerier.query(reqSpec);
		 
		 //get base URI
		 String retrieveBaseURI = queryRequest.getBaseUri();
		 System.out.println("Base URI:" + retrieveBaseURI);
		 
		 //get base path
		 String retrieveBasePath = queryRequest.getBasePath();
		 System.out.println("Base path:" + retrieveBasePath);
		 
		 //get body
		 String retrieveBody = queryRequest.getBody();
		 System.out.println("Body:" + retrieveBody);
		 
		 //get request headers
		 Headers allHeaders = queryRequest.getHeaders();
		 for(Header header:allHeaders) {
			 System.out.println("Header name:" + header.getName() + "Header value:" + header.getValue());
		 }
		 
		 
		 
		 
		 
	
	
	
	
	}
}
