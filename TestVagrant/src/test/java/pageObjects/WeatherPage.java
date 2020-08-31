package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WeatherPage {

	WebDriver driver;

	public WeatherPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchCity(String city) throws Exception {
		driver.findElement(By.id("searchBox")).sendKeys(city);

	}

	public void selectCity(String city) throws Exception {
		if (driver.findElement(By.id("" + city + "")).isSelected()) {

		} else {
			driver.findElement(By.id("" + city + "")).click();
		}
	}

	public String getTempreture(String city) throws Exception {
		return driver.findElement(By.xpath("//div[@title='" + city + "']/div[1]/span[1]")).getText();
	}

}
