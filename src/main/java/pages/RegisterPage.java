package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtills;
import utils.ElementUtils;

public class RegisterPage {
WebDriver driver;
private ElementUtils elementUtils;
public RegisterPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	elementUtils=new ElementUtils(driver);
}
@FindBy(id="input-firstname") private WebElement firstNameField;
@FindBy(id="input-lastname") private WebElement lastNameField;
@FindBy(id="input-email") private WebElement emailField;
@FindBy(id="input-telephone") private WebElement telephoneField;
@FindBy(id="input-password") private WebElement passwordField;
@FindBy(id="input-confirm") private WebElement cfrmpasswordField;
@FindBy(name="agree") private WebElement privacyPolicyOption;
@FindBy(xpath = "//*[@value='Continue']") private WebElement continueButton; 
@FindBy(xpath="//*[@name='newsletter'][@value='1']")private WebElement YesNewsLetterOption;
@FindBy(xpath="//*[contains(@class,'alert-dismissible')]")private WebElement warningMessage;
@FindBy(xpath="//*[@id='input-firstname']/following-sibling::div") private WebElement firstNameWarning;
@FindBy(xpath="//*[@id='input-lastname']/following-sibling::div") private WebElement lastNameWarning;

@FindBy(xpath="//*[@id='input-email']/following-sibling::div") private WebElement emailWarning;

@FindBy(xpath="//*[@id='input-telephone']/following-sibling::div") private WebElement telephoneWarning;

@FindBy(xpath="//*[@id='input-password']/following-sibling::div") private WebElement passwordWarning;



public void enterFirstName(String firstNameText) {
	elementUtils.typeTextIntoElement(firstNameField,firstNameText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//firstNameField.sendKeys(firstNameText);
}
public void enterLastNAme(String lastNameText) {
	elementUtils.typeTextIntoElement(lastNameField,lastNameText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//lastNameField.sendKeys(lastNameText);
}
public void enterEmailAddress(String emailText) {
	elementUtils.typeTextIntoElement(emailField,emailText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//emailField.sendKeys(emailText);
}
public void enterTelephoneNumber(String telephoneText) {
	elementUtils.typeTextIntoElement(telephoneField,telephoneText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//telephoneField.sendKeys(telephoneText);
}public void  selectYesNewsletterOption(){
	elementUtils.clickonElement(YesNewsLetterOption, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//YesNewsLetterOption.click();
	
}
public void enterPassword(String passwordText) {
	elementUtils.typeTextIntoElement(passwordField,passwordText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//passwordField.sendKeys(passwordText);
}
public void confirmPassword(String cfrmpasswordText) {
	elementUtils.typeTextIntoElement(cfrmpasswordField,cfrmpasswordText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//cfrmpasswordField.sendKeys(cfrmpasswordText);
}
public void selectPrivacyPolicy() {
	elementUtils.clickonElement(privacyPolicyOption, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//privacyPolicyOption.click();
}
public AccountSuccessPage clickonContinueButton() {
	elementUtils.clickonElement(continueButton, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//continueButton.click();
	return new AccountSuccessPage(driver);
}
public String getWarningMessageText() {
	return elementUtils.getTextFromElement(warningMessage, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return warningMessage.getText();
}
public String getfirstNameWarning() {
	return elementUtils.getTextFromElement(firstNameWarning, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return firstNameWarning.getText();
	
}
public String getlastNameWarning() {
	return elementUtils.getTextFromElement(lastNameWarning, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return lastNameWarning.getText();
}
public String getEmailWarning() {
	return elementUtils.getTextFromElement(emailWarning, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return emailWarning.getText();
	
}
public String gettelephoneWarning() {
	return elementUtils.getTextFromElement(telephoneWarning, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return telephoneWarning.getText();
	
}
public String getpasswordWarning() {
	return elementUtils.getTextFromElement(passwordWarning, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	//return passwordWarning.getText();
}
}
