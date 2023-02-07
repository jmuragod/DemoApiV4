package com.testcases;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Demo1_PUT_Requests {
	@Test(priority=1)
	public void updateAnEmployeeDetail() {
		HashMap data = new HashMap();
		data.put("name","David");
		data.put("salary","567");
		data.put("age","54");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://dummy.restapiexample.com/api/v1/update/21")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test(priority=2)
	public void updateAnEmployeeDetaileWithNegativeId() {
		HashMap data = new HashMap();
		data.put("name","David");
		data.put("salary","567");
		data.put("age","54");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://dummy.restapiexample.com/api/v1/update/-21")
		.then()
			.statusCode(400)
			.log().all();
	}
	@Test(priority=3)
	public void updateAnEmployeeDetailWithIdAsZero() {
		HashMap data = new HashMap();
		data.put("name","David");
		data.put("salary","567");
		data.put("age","54");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://dummy.restapiexample.com/api/v1/update/0")
		.then()
		.log().all()
		.statusCode(400);
	}
	@Test(priority=4)
	public void updateAnEmployeeDetailWithoutProvidingId() {
		HashMap data = new HashMap();
		data.put("name","David");
		data.put("salary","567");
		data.put("age","54");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://dummy.restapiexample.com/api/v1/update/")
		.then()
			.log().all()
			.statusCode(400);
	}
	@Test(priority=5)
	public void updateAnEmployeeDetailwithoutProvidingAnyInput() {
		HashMap data = new HashMap();
		data.put("name",null);
		data.put("salary",null);
		data.put("age",null);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://dummy.restapiexample.com/api/v1/update/21")
		.then()
			.statusCode(404)
			.log().all();
	}
}
