package by.htp.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page {

	@FindBy(xpath = "//input[@name='subj']")
	private WebElement theme;

	@FindBy(xpath = "id('cke_1_contents')/div")
	private WebElement text;

	@FindBy(xpath = "//a[@href='#sent']//span[text()='Отправленные']")
	public WebElement count2;

	@FindBy(xpath = "//div[@class='mail-User-Name']")
	private WebElement userName;

	@FindBy(xpath = "//span[@class='mail-ComposeButton-Text']")
	private WebElement composeButton;

	@FindBy(xpath = "//a[@href='#sent']")
	private WebElement sentButton;

	@FindBy(xpath = "//a[@href='#inbox']")
	private WebElement inboxButton;

	@FindBy(xpath = "//a[@href='#sent']/div/span")
	//mail-NestedList-Item-Info-Extras
	public WebElement count;

	@FindBy(xpath = "//button/descendant-or-self::span[text()='Отправить']")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//div[@name='to']")
	private WebElement to;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public WebElement getInboxButton() {
		return inboxButton;
	}

	public WebElement getTo() {
		return to;
	}

	public WebElement getSentButton() {
		return sentButton;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getButtonSubmit() {
		return buttonSubmit;
	}

	@Override
	public void openPage(String url) {
		driver.get(url);
	}

	public void clickOnCreateNewLetter() {
		composeButton.click();
	}

	public void clickInboxButton() {
		inboxButton.click();
	}

	public void addTo(String to) {
		this.to.sendKeys(to);
	}

	public void addTheme(String theme) {
		this.theme.sendKeys(theme);
	}

	public void addText(String text) {
		this.text.sendKeys(text);
	}

}
