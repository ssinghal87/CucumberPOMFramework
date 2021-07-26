package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPagesteps {
	
	
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("User has already logged in to Application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	 
		List<Map<String, String>> credList=dataTable.asMaps();
		String username = credList.get(0).get("Username");
		String password = credList.get(0).get("Password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage=loginPage.doLogin(username, password);
	}

	@Given("User is on the Account Page")
	public void user_is_on_the_account_page() {
	  accountsPage.getAccountPagetitle();
	}

	@Then("User gets the account section")
	public void user_gets_the_account_section(DataTable sectionTable) {
		List <String > expectedAccountSectionList=sectionTable.asList();
		System.out.println("Expected Account Section List : -" + expectedAccountSectionList);
		
		List <String > actualAccountSectionList=accountsPage.getAccountsSectionList();
		System.out.println("actual Account Section List : -" + actualAccountSectionList);
		
		Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount()==expectedSectionCount);
		
	}

}
