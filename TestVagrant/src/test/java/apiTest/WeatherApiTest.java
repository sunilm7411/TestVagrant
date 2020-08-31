package apiTest;

import baseConfig.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import verification.ApiVerifications;

public class WeatherApiTest extends BaseTest {
	Response response;

	public Response getCall(String endPoint, String apikey, String city) {
		RequestSpecification request = RestAssured.given();
		response = request.queryParam("q", city).queryParam("appid", apikey).get(endPoint);
		ApiVerifications.responseCodeValiddation(response, 200);
		return response;
	}

}
