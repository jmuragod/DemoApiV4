package com.testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Demo1_DELETE_Request {
	@Test(priority=1)
	public void deleteEmployeeRecord() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/2")
		.then()
		.statusCode(200)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),true);
	}
	@Test(priority=2)
		public void deleteEmployeeRecordWithoutProvidingAnyID() {
			given()
			
			.when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/")
			.then()
			.statusCode(200)
			.log().body();
			
		}
	@Test(priority=3)
		public void deleteEmployeeRecordwithInvalidID() {
			//Response res=
			given()
			
			.when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/200")
			.then()
			.statusCode(400)
			.log().body()
			.extract().response();
			
		}
	@Test(priority=4)
		public void deleteEmployeeRecordWithNegativeID() {
			Response res=
			given()
			
			.when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/-2")
			.then()
			.statusCode(400)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),"invalid Input");
		}
	@Test(priority=5)
		public void deleteEmployeeRecordWithID() {
			Response res=
			given()
			
			.when()
				.delete("https://dummy.restapiexample.com/api/v1/delete/0002")
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),true);
			Assert.assertEquals(JsonString.contains("3"),true);
	}
	@Test(priority=6)
	public void deleteEmployeeRecordWithInvalidId() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/3//")
		.then()
		.statusCode(400)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),"invalid Input");
	}
	@Test(priority=7)
	public void deleteEmployeeRecordsUsingIdWithSpecialChar() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/@#$%2")
		.then()
		.statusCode(400)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("2"),true);
	}
	@Test(priority=8)
	public void deleteEmployeeRecordWithIdasAlphabet() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/ja")
		.then()
		.statusCode(400)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),"invalid Input");
	}
	@Test(priority=9)
	public void deleteEmployeeRecordWithIDAsZero() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/0")
		.then()
		.statusCode(400)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("id is empty"),true);
	}
	@Test(priority=10)
	public void deleteEmployeeRecordWithIDAsBigValue() {
		Response res=
		given()
		
		.when()
			.delete("https://dummy.restapiexample.com/api/v1/delete/7865435786")
		.then()
		.statusCode(400)
		.log().body()
		.extract().response();
		
		String JsonString=res.asString();
		Assert.assertEquals(JsonString.contains("Successfully! Record has been deleted"),"invalid Input");
		
	}
	
}
