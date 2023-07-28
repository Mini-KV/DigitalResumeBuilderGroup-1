package org.ictkerala.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * @author Mini
 */
public class LoginPage {
	WebDriver driver;
	
	public WebElement userName;
	public WebElement password;
	public WebElement loginBtn;
	public WebElement signUpNowBtn;
	public WebElement rememberCheck;
	public WebElement logoutBtn;
	public boolean signUpBtnFlag;
	public boolean loginBtnFlag;
	public boolean logoutBtnFlag;
	public String signUpText;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//login method
	public void loginMethod(String testUser,String testPass) {
		clickSignUpNowBtn();
		setUserName(testUser); 
		setPassword(testPass);  
		tickCheckBox();
		clickLoginBtn();	
	}
	
	//set username
	public void setUserName(String testUser) {
		userName = driver.findElement(By.name("Username"));
		userName.sendKeys(testUser);		
	}
	
	//set password
	public void setPassword(String testPass) {
		password = driver.findElement(By.name("pass"));
		password.sendKeys(testPass);
	}
	
	//click the login Btn
	public void clickLoginBtn() {
		loginBtn = driver.findElement(By.xpath("//button[@class ='login100-form-btn']"));
		loginBtn.click();
	}
	
	//tick the checkbox
	public void tickCheckBox() {
		rememberCheck = driver.findElement(By.xpath("//div[@class='contact100-form-checkbox']"));
		rememberCheck.click();
	}
	
	
	//click the logout Btn
	public void clickLogoutBtn() {
		logoutBtn = driver.findElement(By.xpath("//a[@class ='logout btn']"));
		logoutBtn.click();
	}
	
	//check if logout Btn is visible to validate valid login
	public boolean logoutBtnVisible() {		
		logoutBtn = driver.findElement(By.xpath("//a[@class ='logout btn']"));
		logoutBtnFlag = logoutBtn.isDisplayed();
		return logoutBtnFlag;
	}
	
	//check if sign up Btn is visible to validate invalid login
	public boolean signUpBtnVisible() {
		signUpNowBtn = driver.findElement(By.xpath("//a[@routerlink ='login']"));
		signUpBtnFlag = signUpNowBtn.isDisplayed();
		return signUpBtnFlag;
	}
	
	//check if login Btn is visible to validate login url
	public boolean loginBtnVisible() {
		loginBtn = driver.findElement(By.xpath("//button[@class ='login100-form-btn']"));
		loginBtnFlag = loginBtn.isDisplayed();
		return loginBtnFlag;
	}	
	
	//click the Sign up now button
	public void clickSignUpNowBtn() {
		signUpNowBtn = driver.findElement(By.xpath("//a[@routerlink ='login']"));
		signUpNowBtn.click();
	}
	
	//click the text on sign up page
	public String getSignUpText() {
		signUpText = driver.findElement(By.xpath("//h3[text()='New Account?']")).getText();
		return signUpText;
	}

}
