package com.testcases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

//import io.restassured.response.Response;

public class Demo1_GET_Request {
	@Test(priority=1)
	public void getAllEmployeeData() {
		given()
		
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employees")
		.then()
		.statusCode(200)
		.log().body()
		.header("content-Type", "application/json");
	}
	@Test(priority=2)
	public void getAllEmployeeDataWithInvaliPayload() {
		given()
		
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employee")
		.then()
		.statusCode(200);
		//.log().body()
		//.header("content-Type", "application/json");
	}
	@Test(priority=3)
	public void getSingleEmployeeData() {
		given()
		
		.when()
			.get("https://dummy.restapiexample.com/api/v1/employee/9202")
		.then()
		.statusCode(200)
		.log().body()
		.header("content-Type", "application/json")
		.assertThat().body("name", equalTo("jaya"));
	}
	@Test(priority=4)
		public void getSingleEmployeeDataWithInvalidId() {
		Response res=
			given()
			
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/098")
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("null"),true);
		}
	@Test(priority=5)
		public void getSingleEmployeeDataWithIdAsNegativeValue() {
		Response res=
			given()
			
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/-3")
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),"Bad Request");
		}
		@Test(priority=6)
		public void getSingleEmployeeDataWithIdAsAlphabet() {
		Response res=
			given()
			
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/ja")
			.then()
			.statusCode(200)
			.log().body()
			.extract().response();
			
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),"Bad Request");
		}
		@Test(priority=7)
		public void getSingleEmployeeDataWithIdAsSpecialCharecter() {
		Response res=
			given()
			
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/@#")
			.then()
			.statusCode(404)
			.log().body()
			.extract().response();
			
			
			String JsonString=res.asString();
			Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),"Bad Request");
		}
		@Test(priority=8)
		public void getSingleEmployeeDataWithValidId() {
			given()
			
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employee/3")
			.then()
			.statusCode(200)
			.header("content-Type","application/json")
			.log().all();
		}
		@Test(priority=9)
				public void getSingleEmployeeDataWithId() {
				Response res=
					given()
					
					.when()
						.get("https://dummy.restapiexample.com/api/v1/employee/00004")
					.then()
					.statusCode(200)
					.log().body()
					.extract().response();
					
					String JsonString=res.asString();
					Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),true);
					Assert.assertEquals(JsonString.contains("4"),true);
				}
			@Test(priority=10)
				public void getSingleEmployeeDataProvidingIdWithSpace() {
				Response res=
					given()
					
					.when()
						.get("https://dummy.restapiexample.com/api/v1/employee/     4")
					.then()
					.statusCode(200)
					.log().body()
					.extract().response();
					
					String JsonString=res.asString();
					Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),true);
					Assert.assertEquals(JsonString.contains("4"),true);
				}
			@Test(priority=11)
				public void getSingleEmployeeDataWithoutProvidingId() {
					given()
					
					.when()
						.get("https://dummy.restapiexample.com/api/v1/employee/ ")
					.then()
					.statusCode(404)
					.log().body()
					.extract().response();
				}
			@Test(priority=12)
			public void getSingleEmployeeDataProvidingIdWithSlash() {
			Response res=
				given()
				
				.when()
					.get("https://dummy.restapiexample.com/api/v1/employee/3//")
				.then()
				.statusCode(200)
				.log().body()
				.extract().response();
				
				String JsonString=res.asString();
				Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),true);
				Assert.assertEquals(JsonString.contains("3"),true);
			}
			@Test(priority=13)
			public void getSingleEmployeeDataProvidingIdWithSpaceAndZeros() {
			Response res=
				given()
				
				.when()
					.get("https://dummy.restapiexample.com/api/v1/employee/00004    ")
				.then()
				.statusCode(200)
				.log().body()
				.extract().response();
				
				String JsonString=res.asString();
				Assert.assertEquals(JsonString.contains("\"Successfully! Record has been fetched.\""),true);
				Assert.assertEquals(JsonString.contains("4"),true);
			}
		
		
	
	
}
