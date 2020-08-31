package testCases;

import org.json.JSONObject;
import org.testng.annotations.Test;

import apiEndPointsAndPageUrls.ApiPath;
import apiTest.WeatherApiTest;
import baseConfig.BaseTest;
import io.restassured.response.Response;
import pageObjects.WeatherPage;
import utils.ApiKeys;
import utils.ParseDynamicJson;
import verification.ValueComparison;

public class WeatherCompare extends BaseTest {

	Response response;
	String city = "Bengaluru";
	String UiTempreture;

	@Test
	public void weatherCompare() throws Exception {
		WeatherPage cg = new WeatherPage(driver);
		WeatherApiTest apiTest = new WeatherApiTest();
		cg.searchCity(city);
		cg.selectCity(city);
		UiTempreture = cg.getTempreture(city);
		response = apiTest.getCall(ApiPath.apiPath.GET_WEATHER, ApiKeys.apiKey.GET_WEATHER, city);
		JSONObject inputJSONOBject = new JSONObject(response.asString());
		Object ApiTempreture = ParseDynamicJson.getKey(inputJSONOBject, "temp");
		ValueComparison.varifyValues(UiTempreture.substring(0, UiTempreture.length() - 1), ApiTempreture.toString());
	}
}
