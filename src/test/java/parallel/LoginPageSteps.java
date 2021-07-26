package parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());

	
	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
	 DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	  
		title = loginPage.getLoginPagetitle();
		System.out.println("page title is :" + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("Forgot Password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	  
		Assert.assertTrue(loginPage.isForgotPassworfLinkExist());
	}

	@When("User enters the username {string}")
	public void user_enters_the_username(String username) {
	   loginPage.enterUsername(username);
		
	}

	@When("User enters the password {string}")
	public void user_enters_the_password(String password) {
	   
		loginPage.enterPassword(password);
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
	    
		loginPage.clickOnSignIn();
	}


}
