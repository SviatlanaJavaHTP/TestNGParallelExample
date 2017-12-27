package by.htp.mail.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.model.Letter;
import by.htp.mail.model.User;
import by.htp.mail.pages.LoginPage;
import by.htp.mail.pages.MainPage;

public class Steps {

	private WebDriver driver;

	public void initBrowser(String browserName) {
		driver = DriverSingleton.getWebDriverInstance(browserName);
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginToEmail(User user, String url) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage(url);
		loginPage.login(user.getLogin(), user.getPass());

	}

	public boolean isLoginIn(String name) {
		WebElement elem = new MainPage(driver).getUserName();
		expectedCondition(20, elem);
		String userName = elem.getText();
		return userName.equals(name);
	}

	public int keepQuantitySentMessages() {

		MainPage mainPage = new MainPage(driver);
		WebElement elem = mainPage.getSentButton();
		expectedCondition(20, elem);
		elem.click();

		expectedCondition(20, mainPage.count2);
		int quantity = Integer.parseInt(mainPage.count.getText());// TODO
		mainPage.clickInboxButton();
		return quantity;

	}

	public void createAndSendMessage(Letter letter) {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewLetter();
		WebElement toWeb = mainPage.getTo();
		expectedCondition(10, toWeb);
		writeMessageData(mainPage, letter.getRecipient(), letter.getSender(), letter.getText());
		mainPage.getButtonSubmit().click();
	}

	private void expectedCondition(int time, WebElement element) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
	}

	private void writeMessageData(MainPage mainPage, String to, String theme, String text) {
		mainPage.addTo(to);
		mainPage.addTheme(theme);
		mainPage.addText(text);
	}

	public static void timeout(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
