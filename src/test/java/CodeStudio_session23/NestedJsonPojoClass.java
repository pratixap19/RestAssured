package CodeStudio_session23;

import java.util.List;

import CodeStudio_session22.EmpPojoClass;

public class NestedJsonPojoClass {
	
	private String compnyName;
	private String Street;
	private String City;
	private String pincode;
	private String state;
	private List<String> bankAccount;
	private List<EmpPojoClass> employeeList;
	
	public String getCompnyName() {
		return compnyName;
	}
	public void setCompnyName(String compnyName) {
		this.compnyName = compnyName;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}
	public List<EmpPojoClass> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmpPojoClass> employeeList) {
		this.employeeList = employeeList;
	}
	
	

}
