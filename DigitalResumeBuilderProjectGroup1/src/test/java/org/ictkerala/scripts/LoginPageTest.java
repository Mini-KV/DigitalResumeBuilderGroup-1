package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.pages.LoginPage;
import org.ictkerala.pages.SignUpPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @author Mini
 */
public class LoginPageTest extends TestBase {
	
	LoginPage login;
	SignUpPage signup;
	
	@BeforeMethod
	public void intitMethod() {
		login = new LoginPage(driver);
		signup = new SignUpPage(driver);
	}

	//verify login link redirects to correct page
	@Test(priority=1,description="verify login link")
	public void verifyLoginLink() throws IOException {		
		login.clickSignUpNowBtn();
		Assert.assertTrue(login.loginBtnVisible());
	}
	
	//verify login with valid user name and valid password
	@Test(priority=2,description="valid username/password")
	public void validLogin() throws IOException {	
		String userName =ExcelUtility.readExcel(1,0,"Login");
		String password =ExcelUtility.readExcel(1,1,"Login");
		login.loginMethod(userName,password);
		Assert.assertTrue(login.logoutBtnVisible());
	}
	
	//verify login with valid user name and invalid password
	@Test(priority=3,description="valid username/invalid password")
	public void validUserInvalidPassword() throws IOException {		
		String userName =ExcelUtility.readExcel(2,0,"Login");
		String password =ExcelUtility.readExcel(2,1,"Login");
		login.loginMethod(userName,password);
		Assert.assertTrue(login.signUpBtnVisible());
	}
	
	//verify login with null user name and valid password
	@Test(priority=4,description="null username/valid password")
	public void nullUserValidPassword() throws IOException {
		String userName ="";
		String password =ExcelUtility.readExcel(1,1,"Login");
		login.loginMethod(userName,password);
		Assert.assertTrue(login.signUpBtnVisible());
	}
	
	//verify login with valid user name and null password
	@Test(priority=5,description="valid username/null password")
	public void validUsernullPassword() throws IOException {		
		String userName =ExcelUtility.readExcel(1,0,"Login");
		String password ="";
		login.loginMethod(userName,password);
		Assert.assertTrue(login.signUpBtnVisible());
	}
		
	//verify logout
	@Test(priority=6,description="logout")	
	public void Logout() throws IOException {	
		String userName =ExcelUtility.readExcel(1,0,"Login");
		String password =ExcelUtility.readExcel(1,1,"Login");
		login.loginMethod(userName,password);
		login.clickLogoutBtn();
		Assert.assertTrue(login.signUpBtnVisible());
		}
}
