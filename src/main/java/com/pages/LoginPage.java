package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	// every class will be having the private Webdriver
	
	private WebDriver driver;
	
	// by locators
	
	private By emailField= By.id("email");
	private By passwordField= By.id("passwd");
	private By SignInButton= By.id("SubmitLogin");
	private By forgotPasswordLink=By.linkText("Forgot your password?sdfghj");
	
	
	// constructor
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public String getLoginPagetitle() {
		
		return driver.getTitle();
	}
	
    public boolean isForgotPassworfLinkExist() {
		
		 return driver.findElement(forgotPasswordLink).isDisplayed();
	}
    
    
    public void enterUsername(String username) {
    	
    	driver.findElement(emailField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	
    	driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickOnSignIn() {
    	
    	driver.findElement(SignInButton).click();
    }
    
 public AccountsPage doLogin(String un, String psw) {
    	
	 driver.findElement(emailField).sendKeys(un);
	 driver.findElement(passwordField).sendKeys(psw);
	 driver.findElement(SignInButton).click();
	 return new AccountsPage(driver);
	 
    }
	
	
	
	// page actions


}
