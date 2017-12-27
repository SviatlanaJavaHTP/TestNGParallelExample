package by.htp.mail.driver.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverCreatorForName {

	private static WebDriver driver;		
	
	
	public static WebDriver getDriver(String driverName) {

		switch (getDriverName(driverName)) {
		case CHROME:
			WebDriverCreator creatorChro = new ChromeDriverCreator();
			driver = creatorChro.factoryMethod();
			break;
		case IE:
			WebDriverCreator creatorIE = new IEDriverCreator();
			driver = creatorIE.factoryMethod();
			break;
		case FIREFOX:
			WebDriverCreator creatorFF = new FirefoxDriverCreator();
			driver = creatorFF.factoryMethod();
			break;
		default:
			break;
		}
		return driver;
	}


	private static DriverName getDriverName(String driverName) {
		return DriverName.valueOf(driverName.toUpperCase());
	}

}

enum DriverName{
	FIREFOX,
	CHROME,
	IE
}