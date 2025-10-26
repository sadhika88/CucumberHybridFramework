package stepDefiniations;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtills;

public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtills commonUtills;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
	   driver=DriverFactory.getDriver();
	   HomePage homepage=new HomePage(driver);
	   homepage.clickOnMyAccount();
	   registerpage=homepage.selectRegisterOption();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	   Map<String, String> datamap=dataTable.asMap(String.class, String.class);
	   
	  registerpage.enterFirstName(datamap.get("firstName"));
	   registerpage.enterLastNAme(datamap.get("lastName"));
	   commonUtills=new CommonUtills();
	   registerpage.enterEmailAddress(commonUtills.getEmailWithTimeStamp());
	   registerpage.enterTelephoneNumber(datamap.get("telephone"));
	   registerpage.enterPassword(datamap.get("password"));
	   registerpage.confirmPassword(datamap.get("password"));
	}
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	   Map<String, String> datamap=dataTable.asMap(String.class, String.class);
	  
		  registerpage.enterFirstName(datamap.get("firstName"));
		   registerpage.enterLastNAme(datamap.get("lastName"));
		   registerpage.enterEmailAddress(datamap.get("email"));
		   registerpage.enterTelephoneNumber(datamap.get("telephone"));
		   registerpage.enterPassword(datamap.get("password"));
		   registerpage.confirmPassword(datamap.get("password"));
	  
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	  registerpage.selectPrivacyPolicy();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
	  accountSuccessPage= registerpage.clickonContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	
		 Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());
	}
	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	
		registerpage.selectYesNewsletterOption();
	}

	

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	  Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	    //registerpage=new RegisterPage(driver);
		//Intenionally kept Blank
		registerpage.enterFirstName("");
		   registerpage.enterLastNAme("");
		   registerpage.enterEmailAddress("");
		   registerpage.enterTelephoneNumber("");
		   registerpage.enterPassword("");
		   registerpage.confirmPassword("");
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    Assert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	    Assert.assertEquals("First Name must be between 1 and 32 characters!", registerpage.getfirstNameWarning());
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerpage.getlastNameWarning());
	    Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getEmailWarning());
	    Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.gettelephoneWarning());
	    Assert.assertEquals("Password must be between 4 and 20 characters!", registerpage.getpasswordWarning());
	    
	}
	

	


}
