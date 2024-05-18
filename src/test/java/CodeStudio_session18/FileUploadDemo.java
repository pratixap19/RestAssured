package CodeStudio_session18;
//Session # 18 - How To Upload File In Rest Assured
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FileUploadDemo {
	
	@Test
	public void uploadFile() {
		
		//create file object
		File testFileUpload = new File("C:\\Users\\prati\\Desktop\\testFileUpload.txt");
		File testFileUpload2 = new File("C:\\Users\\prati\\Desktop\\testFileUpload2.txt");
		
		//create requestSpecification
		 RequestSpecification requestSpec = RestAssured.given();
		 requestSpec.baseUri("http://httpbin.org/post");
		 requestSpec.multiPart("files",testFileUpload);
		 requestSpec.multiPart("files",testFileUpload2);
		 requestSpec.contentType("multipart/form-data");//it may ask in interview
		 
		 //perform post request
		 Response response = requestSpec.post();
		 response.prettyPrint();
		 
		 //validate status code
		 Assert.assertEquals(response.statusCode(),200, "Validate status code");
		
	}
}
