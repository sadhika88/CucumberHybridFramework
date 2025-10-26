package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtills;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementUtils;
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(xpath = "//span[normalize-space()='My Account']") private WebElement myaccountDropMenu;
	@FindBy(linkText ="Login") private WebElement loginOption;	
	@FindBy(linkText = "Register") private WebElement registerOption;
	@FindBy(name = "search") private WebElement searchBoxField;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") private WebElement searchButton;
	public void clickOnMyAccount() {
		//myaccountDropMenu.click();
		elementUtils.clickonElement(myaccountDropMenu, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
	}
	public LoginPage selectLoginoption() {
		//loginOption.click();
		elementUtils.clickonElement(loginOption, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		elementUtils.clickonElement(registerOption, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
		//registerOption.click();
		return new RegisterPage(driver);
	}
	public void enterProductIntoSearchBox(String ProductText) {
		
		elementUtils.typeTextIntoElement(searchBoxField, ProductText, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
		//searchBoxField.sendKeys(ProductText);
	}
	public SearchResultsPage clickonSearchButton() 
	{
		elementUtils.clickonElement(searchButton, CommonUtills.EXPLICIT_WAIT_BASIC_TIME);
		//searchButton.click();
		return new SearchResultsPage(driver);
	}
}

