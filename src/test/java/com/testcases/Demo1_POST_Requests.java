package com.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Demo1_POST_Requests {
	@Test(priority=1)
	public void test_CreateNewRecordInDatabase() {
		HashMap data = new HashMap();
		data.put("name", "jaya");
		data.put("salary","2345");
		data.put("age","34");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),true);
	}
	@Test(priority=2)
	public void test_CreateWithoutProvidingAnyInputs() {
		HashMap data = new HashMap();
		data.put("name",null);
		data.put("salary",null);
		data.put("age",null);//
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"invalid inputs");
	}
	@Test(priority=3)
	public void test_CreateWithoutProvidingName() {
		HashMap data = new HashMap();
		data.put("name",null);
		data.put("salary","67854");
		data.put("age","56");//
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"invalid input");
	}
	@Test(priority=4)
	public void test_CreateWithoutProvidingNameAndSalary() {
		HashMap data = new HashMap();
		data.put("name",null);
		data.put("salary",null);
		data.put("age","56");//
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"invalid input");
	}
	@Test(priority=5)
	public void test_CreateWithoutProvidingSalary() {
		HashMap data = new HashMap();
		data.put("name","john");
		data.put("salary",null);
		data.put("age","56");//
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"invalid input");
	}
	@Test(priority=6)
	public void test_CreateWithoutProvidingSalaryAndAge() {
		HashMap data = new HashMap();
		data.put("name","john");
		data.put("salary",null);
		data.put("age",null);//
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"invalid input");
	}
	@Test(priority=7)
	public void test_CreateWithoutProvidingNegativeSalary() {
		HashMap data = new HashMap();
		data.put("name","john");
		data.put("salary","-567");
		data.put("age","54");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Salary Should not be negative value");
	}
	@Test(priority=8)
	public void test_CreateWithoutProvidingNegativeAge() {
		HashMap data = new HashMap();
		data.put("name","john");
		data.put("salary","567");
		data.put("age","-54");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Age Should not be in negative value");
	}
	@Test(priority=9)
	public void test_CreateWithoutProvidingNameasNull() {
		HashMap data = new HashMap();
		data.put("name",null);
		data.put("salary","567");
		data.put("age","-54");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Name should not be null");
	}
	@Test(priority=10)
	public void test_CreateWithoutProvidingNameasNumber() {
		HashMap data = new HashMap();
		data.put("name","3456");
		data.put("salary","567");
		data.put("age","-54");
		
		Response res=
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://dummy.restapiexample.com/api/v1/create")
		
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),false);
	}
	@Test(priority=11)
		public void test_CreateWithoutProvidingSalaryasAlphaNumericValue() {
			HashMap data = new HashMap();
			data.put("name","3456");
			data.put("salary","567@#$g");
			data.put("age","-54");
			
			Response res=
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Salary should be a Number");
		}
		
	@Test(priority=12)
		public void test_CreateUserProvidingAgeasAlphaNumericValue() {
			HashMap data = new HashMap();
			data.put("name","3456");
			data.put("salary","567");
			data.put("age","-54#$%fg");
			
			Response res=
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Age should be a Number");
		}
	@Test(priority=13)
		public void test_CreateWithoutProvidingAgeasZero() {
			HashMap data = new HashMap();
			data.put("name","3456");
			data.put("salary","567");
			data.put("age","0000");
			
			Response res=
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"Age should not be a Zero");
		}
	@Test(priority=14)
		public void test_CreateUserWhichIsAlreadyCreated() {
			HashMap data = new HashMap();
			data.put("name","jaya");
			data.put("salary","2345");
			data.put("age","34");
			
			Response res=
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post("https://dummy.restapiexample.com/api/v1/create")
			
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been added."),"This Data is already taken!!");
		}
	

	
	
	
}
