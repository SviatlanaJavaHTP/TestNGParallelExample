package by.htp.mail.driver;

import org.openqa.selenium.WebDriver;

//import by.htp.mail.driver.factory.ChromeDriverCreator;
//import by.htp.mail.driver.factory.WebDriverCreator;
import by.htp.mail.driver.factory.WebDriverCreatorForName;

public class DriverSingleton {

	private static WebDriver driver;

	private DriverSingleton() {}
	
	public static void closeDriver() {
		driver.close();
		driver = null;
	}

	public static WebDriver getWebDriverInstance(String browserName) {
		if (null == driver) {
//			WebDriverCreator creator = new ChromeDriverCreator();
//			driver = creator.factoryMethod();
			driver = WebDriverCreatorForName.getDriver(browserName);
		}
		return driver;
	}
}
