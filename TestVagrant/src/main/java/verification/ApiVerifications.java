package verification;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListner;

public class ApiVerifications extends ExtentReportListner {

	public static void responseCodeValiddation(Response response, int statusCode) {

		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS,
					"Successfully validdated status code, status code is :: " + response.getStatusCode());
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL,
					"Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
		}
	}
}
