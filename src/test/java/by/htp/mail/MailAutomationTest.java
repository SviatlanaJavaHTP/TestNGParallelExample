package by.htp.mail;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.htp.mail.model.Letter;
import by.htp.mail.model.User;
import by.htp.mail.steps.Steps;

public class MailAutomationTest {

	private Steps steps;

	private final String URL = "https://yandex.by/";

	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {
		steps = new Steps();
		steps.initBrowser(browser);
	}

	@Test(description = "", priority = 1, enabled = true)
	public void oneCanLoginToEmail() {
		User user = new User();
		steps.loginToEmail(user, URL);
		assertTrue(steps.isLoginIn(user.getUsername()));
	}

	@Test(description = "", priority = 2, enabled = false)
	public void oneCanSendEmail() {
		int firstQuantity = steps.keepQuantitySentMessages();
		steps.createAndSendMessage(new Letter());
		Steps.timeout(20000);
		int secondQuantity = steps.keepQuantitySentMessages();
		System.out.println(firstQuantity + " " + secondQuantity);
		assertTrue(firstQuantity == secondQuantity - 1);
	}

	@AfterTest
	public void stopBrowser() {
		steps.closeDriver();
	}

}
