package org.ictkerala.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * @author Mini
 */
public class SignUpPage {
	WebDriver driver;
		
	public WebElement signUpBtn;
	public WebElement userName;
	public WebElement password;
	public WebElement confPass;
	public WebElement phoneNumber;
	public WebElement mail;
	public WebElement regBtn;
	String signUpAlertText;

	public WebElement userNameError;
	public WebElement phoneNumberError;
	public WebElement emailError;
	public WebElement passwordError;
	public WebElement confPassError;
	
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	

	//click the Sign up  button
	public void clickSignUpBtn() {
		signUpBtn = driver.findElement(By.xpath("//a[@routerlink='/signup']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView();", signUpBtn);
		js.executeScript("arguments[0].click();",signUpBtn);
	}
	
	//set user name
	public void setUserName(String inpUser) {
		userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		userName.sendKeys(inpUser);
	}
	
	//set password
	public void setPassword(String inpPass) {
		password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys(inpPass);
	}
	
	//set confirm password
	public void setConfPassword(String inpConfPass) {
		confPass = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		confPass.sendKeys(inpConfPass);
	}
	
	public void setPhone(String inpPhone) {
		phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		phoneNumber.sendKeys(inpPhone);
	}
	
	//set email
	public void setEmail(String inpMail) {
		mail = driver.findElement(By.xpath("//input[@placeholder='Mail']"));
		mail.sendKeys(inpMail);
	}
	
	//click register button
	public void clickRegisterBtn () {
		regBtn = driver.findElement(By.xpath("//span[text()='Register']"));
		regBtn.click();
	}
	
	//get the alert message on successful sign in
	public String getsignUpAlert() {
		Alert signUpAlert = driver.switchTo().alert();
		signUpAlertText = signUpAlert.getText();	
		signUpAlert.accept();
		return signUpAlertText;		
	} 
	
	//get username missing error
	public String getUserNameError() {
		userNameError = driver.findElement(By.xpath("//input[@placeholder='Username']//following::div//child::div"));			
		return userNameError.getText();
	} 
	
	//get phone number missing error
	public String getPhoneNoError() {
		phoneNumberError = driver.findElement(By.xpath("//input[@placeholder='Phone Number']//following::div//child::div"));			
		return phoneNumberError.getText();	
	} 

	//get email missing error
	public String getEmailError() {
		emailError = driver.findElement(By.xpath("//input[@placeholder='Mail']//following::div//child::div"));			
		return emailError.getText();	
	} 

	//get password  missing error
	public String getPassError() {
		passwordError = driver.findElement(By.xpath("//input[@placeholder='Password']//following::div//child::div"));			
		return passwordError.getText();	
	} 

	//get confirm password missing error
	public String getConfPassError() {
		confPassError = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']//following::div//child::div"));			
		return confPassError.getText();	
	}
}
