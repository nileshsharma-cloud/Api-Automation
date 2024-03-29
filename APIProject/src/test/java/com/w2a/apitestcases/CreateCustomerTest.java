package com.w2a.apitestcases;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import com.w2a.ApiTestingFramework.setup.BaseTest;
import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test
	public void validateCreateTestWithValidApiSecretKey() {

		Response response = given().auth().basic("sk_test_4ntAgFgOUA3aBcy2sLeCFD9700W2SGvlAb", "")
				.formParam("name", "Nilesh Sharma").formParam("description", "Api Automation Engineer")
				.formParam("email", "testing4@getnada.com").post("/customers");

		response.prettyPrint();
		System.out.println("Status code " + response.getStatusCode());

	}
}
