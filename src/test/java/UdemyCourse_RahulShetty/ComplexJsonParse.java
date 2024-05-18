package UdemyCourse_RahulShetty;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	@Test
	public void jsonParse() {
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.getInt("courses.size()");
		System.out.println("Course size is : " +count);
		
		 int amount = js.getInt("dashboard.purchaseAmount");
		 System.out.println("Purchase amount is : " + amount);
		 //get t
		
		
	}

}
