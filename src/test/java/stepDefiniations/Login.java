package stepDefiniations;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lv.Tad;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtills;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtills commonUtills;
	

@Given("User navigates to login page")
public void user_navigates_to_login_page() {
	
	driver=DriverFactory.getDriver();
	HomePage homepage=new HomePage(driver);
	homepage.clickOnMyAccount();
   loginpage= homepage.selectLoginoption();

}

@When("^User enters valid email (.+) into the email field$")
public void user_enters_valid_email_into_the_email_field(String emailText) {
   
    loginpage.enterEmailAddress(emailText);
}

@And("^User enters valid password (.+) into password field$")
public void user_enters_valid_password_into_password_field(String pwdText) {
	 
	 loginpage.enterpwdAddress(pwdText);
}

@And("User clicks on Login button")
public void user_clicks_on_login_button() {
    accountpage=loginpage.clickonLoginButton();
}

@Then("User should get successfully logged in")
public void user_should_get_successfully_logged_in() {
	
	Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformationOption());
}

@And("User enters invalid email address  into email field")

public void user_enters_invalid_email_address_into_email_field() {
	 commonUtills=new CommonUtills();
	loginpage.enterEmailAddress(commonUtills.getEmailWithTimeStamp());
	 //driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
}

@And("User enters invalid password {string} into password field")
public void user_enters_invalid_password_into_password_field(String Invalidpwd) {
	loginpage.enterpwdAddress(Invalidpwd);
	
	 //driver.findElement(By.id("input-password")).sendKeys(Invalidpwd);
}

@Then("User should get a proper warning message about credentials mismatch")
public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	

}
@When("User dont enter email address into email field")
public void user_dont_enter_email_address_into_email_field() {
	
	loginpage.enterEmailAddress("");
   //driver.findElement(By.id("input-email")).sendKeys("");
}

@When("User dont enter password into password field")
public void user_dont_enter_password_into_password_field() {
	loginpage.enterpwdAddress("");
	 //driver.findElement(By.id("input-password")).sendKeys("");
}


}
