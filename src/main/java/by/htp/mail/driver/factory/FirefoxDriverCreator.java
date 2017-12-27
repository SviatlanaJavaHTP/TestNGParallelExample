package by.htp.mail.driver.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverCreator extends WebDriverCreator {

		private final String WEBDRIVER = "webdriver.gecko.driver";
		private final String PATH = "c:\\driver\\geckodriver.exe";
		
		@Override
		public WebDriver factoryMethod() {
			
			System.setProperty(WEBDRIVER, PATH);
			driver = new FirefoxDriver();

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			return driver;
		}

	}

