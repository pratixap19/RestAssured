package CodeStudio_session23;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ComplexNestedJsonObject {
	@Test
	public void createUser() {
		NestedJsonPojoClass requestPayload = new NestedJsonPojoClass();
		requestPayload.setCompnyName("xyz Ltd");
		requestPayload.setStreet("Arifac Avenue");
		requestPayload.setCity("RK Puram, Delhi");;
		requestPayload.setState("New Delhi");
		requestPayload.setPincode("112345");
		
		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI");
		banks.add("AXIS");
		requestPayload.setBankAccount(banks);
		
		requestPayload.setEmployeeList(null);
		
		
	}
}
