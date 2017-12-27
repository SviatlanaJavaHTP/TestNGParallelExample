package by.htp.mail.driver.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverCreator extends WebDriverCreator {

	private final String WEBDRIVER_IE = "webdriver.ie.driver";
	private final String IE_PATH = "c:\\driver\\chromedriver\\IEDriverServer_x32_3.8.0.exe";

	@Override
	public WebDriver factoryMethod() {

		System.setProperty(WEBDRIVER_IE, IE_PATH);
		driver = new InternetExplorerDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

}
