package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtills;
import utils.ElementUtils;

public class LoginPage {
	WebDriver driver;
	ElementUtils elementUtils;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(id="input-email") private WebElement emailField;
	@FindBy(id="input-password") private WebElement pwdField;
	@FindBy(xpath = "//input[@value='Login']") private WebElement loginButton;
	@FindBy(xpath = "//*[contains(@class,'alert-dismissible')]") private WebElement warningMessage;
	public void enterEmailAddress(String emailText) {
		//emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	}
	public void enterpwdAddress(String pwdText) {
		elementUtils.typeTextIntoElement(pwdField, pwdText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//pwdField.sendKeys(pwdText);
	}
	public AccountPage clickonLoginButton() {
		elementUtils.clickonElement(loginButton, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
		//loginButton.click();
		return new AccountPage(driver);
	}
	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//	return warningMessage.getText();
		
	}
}
