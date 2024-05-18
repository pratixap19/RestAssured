package CodeStudio_session20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerealizationAndDeserialization {
	@Test
	public void createJSONObjectFromEmployeeClassObject() throws JsonProcessingException {
		//create Employee POJO class
		Employee emp1 = new Employee();
		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehra");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(10000.00);
		
		//convert employee class to JSON payload as string
		ObjectMapper objMapper = new ObjectMapper();
		String employeeJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println("converted object to Json object:" + employeeJSON);
		
		 RequestSpecification reqSpec = RestAssured.given();
		 reqSpec.baseUri("http://httpbin.org/post");
		 reqSpec.contentType(ContentType.JSON);
		 reqSpec.body(employeeJSON);
		 Response response = reqSpec.post();
		 response.prettyPrint();
		 //validate status code
		 Assert.assertEquals(response.statusCode(), 200, "Validate status code");
		 
		 //convert JSON string(employeeJSON)to class object-deserialization
		 Employee emp2 = objMapper.readValue(employeeJSON, Employee.class);
		 
		 System.out.println("Print Json object to class object-deserialization");
		 System.out.println("Firstname:" + emp2.getFirstName());
		 System.out.println("Last name:" + emp2.getLastName());
		 System.out.println("Gender:" + emp2.getGender());
		 System.out.println("Age:" + emp2.getAge());
		 System.out.println("Salary:" + emp2.getSalary());
	}
}
