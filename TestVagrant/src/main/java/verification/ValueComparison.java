package verification;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.ExtentReportListner;

public class ValueComparison extends ExtentReportListner {

	public static void varifyValues(String ui, String api) {

		try {
			Assert.assertEquals(ui, api);
			test.log(LogStatus.PASS, "Successfully validdated value is :: ");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL, "Expected value is :: " + ui + " , insted of getting :: " + api);
		}
	}

}
