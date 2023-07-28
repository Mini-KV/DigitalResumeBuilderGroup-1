package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.pages.SignUpPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @author Mini
 */
public class SignUpPageTest extends TestBase{
	
	SignUpPage signup;
	LoginPage login;
	
	@BeforeMethod
	public void intitMethod() {
		signup = new SignUpPage(driver);
		login = new LoginPage(driver);
		
		login.clickSignUpNowBtn();
	}
	
	//verify Signup Now link redirects to correct page
	@Test(priority=1,description="verify Signup Now link")
	public void verifySignUpNowLink() throws IOException {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, AutomationConstants.expectedSignUpUrl);
	}
	
	//verify signup link redirects to correct page
	@Test(priority=2,description="verify signup link")
	public void verifySignUpLink() throws IOException {
		signup.clickSignUpBtn();
		Assert.assertEquals(login.getSignUpText(), AutomationConstants.expectedSignUpText);
	}
	
	//verify valid sign up
	@Test(priority=3,description="signup with valid data")
	public void validSignUpTest() throws IOException {
		String userName =ExcelUtility.readExcel(1,0,"SignUp");
		String phoneNo =ExcelUtility.readExcel(1,1,"SignUp");
		String eMail = ExcelUtility.readExcel(1,2,"SignUp");
		String password = ExcelUtility.readExcel(1,3,"SignUp");
		String confPassword = ExcelUtility.readExcel(1,4,"SignUp");
		signup.clickSignUpBtn();
		signup.setUserName(userName);
		signup.setPhone (phoneNo);
		signup.setEmail (eMail);
		signup.setPassword (password);
		signup.setConfPassword (confPassword);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getsignUpAlert(), AutomationConstants.expectedSignUpAlert);
	}
	
	//verify if mandatory fields give error on blank
	@Test(priority=4,description="sign up with blank fields")
	public void blankFieldsTest() throws IOException {
		signup.clickSignUpBtn();
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getUserNameError(), AutomationConstants.expectedUsernameError);
		Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.expectedPhoneError);
		Assert.assertEquals(signup.getEmailError(), AutomationConstants.expectedEmailError);
		Assert.assertEquals(signup.getPassError(), AutomationConstants.expectedPassError);
		Assert.assertEquals(signup.getConfPassError(), AutomationConstants.expectedConfPassError);
	}
	
	//verify error when user name less than 4 char
	@Test(priority=5,description="user name less than 4 char")
	public void userNameLessThan4Char() throws IOException {
		String userName = ExcelUtility.readExcel(2,0,"SignUp"); 
		signup.clickSignUpBtn();
		signup.setUserName(userName);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getUserNameError(), AutomationConstants.expectedUsername4CharMsg);
	}
	
	//verify error when user name greater than 20 char
	@Test(priority=6,description="user name greater than 20 char")
	public void userNameMoreThan20Char() throws IOException {
		String userName = ExcelUtility.readExcel(3,0,"SignUp"); 
		signup.clickSignUpBtn();
		signup.setUserName(userName);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getUserNameError(), AutomationConstants.expectedUsername20CharMsg);
	}
	
	//verify error when phone number greater than 10 digits
	@Test(priority=7,description="phone number greater than 10 digits")
	public void phoneMoreThan10() throws IOException {
		String phoneNo = ExcelUtility.readExcel(2,1,"SignUp"); 
		signup.clickSignUpBtn();
		signup.setPhone (phoneNo);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.expectedPhoneNoMsg);
	}
		
	//verify error when phone number less than 10 digits
	@Test(priority=8,description="phone number less than 10 digits")
	public void phoneLessThan10() throws IOException {
		String phoneNo = ExcelUtility.readExcel(3,1,"SignUp"); 
		signup.clickSignUpBtn();
		signup.setPhone (phoneNo);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.expectedPhoneNoMsg);
	}	
	
	//verify error when phone number has invalid characters
	@Test(priority=9,description="phone number invalid characters")
	public void phoneNoInvalidChar() throws IOException {
		String phoneNo = ExcelUtility.readExcel(4,1,"SignUp"); 
		signup.clickSignUpBtn();
		signup.setPhone (phoneNo);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getPhoneNoError(), AutomationConstants.expectedPhoneNoMsg);
	}	
		
	//verify error when email is not in correct format
	@Test(priority=10,description="email invalid")
	public void emailInvalidChar() throws IOException {
		String eMail =ExcelUtility.readExcel(2,2,"SignUp");
		signup.clickSignUpBtn();
		signup.setEmail (eMail);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getEmailError(), AutomationConstants.expectedEmailMsg);
	}	
	
	//verify error when password less than 6 char
	@Test(priority=11,description="password less than 6 char")
	public void passLessThan6Char() throws IOException {
		String password  = ExcelUtility.readExcel(2,3,"SignUp");
		signup.clickSignUpBtn();
		signup.setPassword (password);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getPassError(), AutomationConstants.expectedPassLess6CharMsg);
	}
	
	//verify error when password does meet specifications
	@Test(priority=12,description="password invalid")
	public void passInvalid() throws IOException {
		String password  = ExcelUtility.readExcel(3,3,"SignUp");
		signup.clickSignUpBtn();
		signup.setPassword (password);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getPassError(), AutomationConstants.expectedPasswordMsg);
	}	
	
	//verify error when confirm password does not match password
	@Test(priority=13,description="confirm password different")
	public void confirmPassNotMatching() throws IOException {
		String password  = ExcelUtility.readExcel(4,3,"SignUp");
		String confPassword  = ExcelUtility.readExcel(4,4,"SignUp");
		signup.clickSignUpBtn();
		signup.setPassword (password);
		signup.setConfPassword (confPassword);
		signup.clickRegisterBtn();
		Assert.assertEquals(signup.getConfPassError(), AutomationConstants.expectedConfPasswordMsg);
	}	

}
