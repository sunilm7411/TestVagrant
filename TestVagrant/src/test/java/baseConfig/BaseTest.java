package baseConfig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.restassured.RestAssured;
import utils.ExtentReportListner;

@Listeners(ExtentReportListner.class)
public class BaseTest extends ExtentReportListner {

	public WebDriver driver;

	@BeforeMethod
	public void tearUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://social.ndtv.com/static/Weather/report/");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
