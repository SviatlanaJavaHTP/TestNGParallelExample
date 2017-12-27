package by.htp.mail.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	
	protected WebDriver driver;

	public abstract void openPage(String url);

	public Page(WebDriver driver) {
		this.driver = driver;
	}
}
