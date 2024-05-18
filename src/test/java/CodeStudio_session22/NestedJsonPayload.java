package CodeStudio_session22;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/*
 {
  "firstname" : "Suresh",
  "lastname" : "Mehra",
  "gender" : "Male",
  "age" : 35,
  "salary" : 18000.0,
  "address" : {
    "street" : "Park Avenue",
    "city" : "Vijaywada",
    "state" : "Andhra Pradesh",
    "pincode" : 234567
  }
}*/

public class NestedJsonPayload {
	
	@Test
	public void createUser() throws JsonProcessingException {
		EmpPojoClass emp1 = new EmpPojoClass();
		emp1.setFirstname("Suresh");
		emp1.setLastname("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(18000.00);
		
		EmpAddress emp1Address = new EmpAddress();
		emp1Address.setStreet("Park Avenue");
		emp1Address.setCity("Vijaywada");
		emp1Address.setState("Andhra Pradesh");
		emp1Address.setPincode(234567);
		emp1.setAddress(emp1Address);
		
		//convert class object to Json object as a string
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonpayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(jsonpayload);
		
		//create request with POST method
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		Response response = reqSpec.body(jsonpayload).post();
		System.out.println("==============Response body================");
		System.out.println(response.prettyPrint());
		
		//convert JSON string(employeeJSON)to class object-deserialization
		EmpPojoClass employee = objectMapper.readValue(jsonpayload, EmpPojoClass.class);
		System.out.println(employee.getFirstname());
		System.out.println(employee.getLastname());
		System.out.println(employee.getGender());
		System.out.println(employee.getAge());
		System.out.println(employee.getSalary());
		System.out.println(employee.getAddress());
		
		
	}
}
