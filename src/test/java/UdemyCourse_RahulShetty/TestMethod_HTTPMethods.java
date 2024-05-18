package UdemyCourse_RahulShetty;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

//Followed Rahul Shetty
//Given - all input details you give to submit API
//When - Submit the API - resource, http methods goes under when()
//Then - validate the response

//validate if Add Place API is working as expected
//Add place->Update place with New Address->Get place to validate if new address is present in the response.

public class TestMethod_HTTPMethods {
	static String placeID;
	public static void main(String[] args) {
		
		//Post method/Add place
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		//equalT0() method is coming from hamcrest package and it is by nature static.
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		placeID = js.getString("place_id");
		System.out.println("placeID : " + placeID);
		
		//Update place
		String newAddress = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\"\"+placeID+\"\\", \r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		

		//Get place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
		.when().get("/maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().asString();
		
		 JsonPath js1 = ReusableMethods.rawToJson(getPlaceResponse);
		 String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		
		
	}

}
