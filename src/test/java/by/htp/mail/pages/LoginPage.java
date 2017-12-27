package by.htp.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{

	@FindBy(xpath = "//span/input[@placeholder='Логин']")
	private WebElement inputLogin;
	
	@FindBy(name = "login")
	private WebElement inputLoginName;
	
	@FindBy(xpath = "//span/input[@placeholder='Пароль']")
	private WebElement inputPassword;

	//span[text()='Âîéòè']
	@FindBy(xpath = "//span[text()='Войти']/parent::button")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this); //TODO
	}

	@Override
	public void openPage(String url) {
		driver.get(url);
	}

	public void login(String username, String password)
	{
		inputLogin.click();
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
	}
	
}
