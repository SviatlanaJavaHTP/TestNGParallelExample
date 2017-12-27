package by.htp.mail.driver.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverCreator extends WebDriverCreator {

	private static final String WEBDRIVER_CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "c:\\driver\\chromedriver\\chromedriver.exe";
	
	@Override
	public WebDriver factoryMethod() {
		
		System.setProperty(WEBDRIVER_CHROME, CHROME_PATH);
		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

}
