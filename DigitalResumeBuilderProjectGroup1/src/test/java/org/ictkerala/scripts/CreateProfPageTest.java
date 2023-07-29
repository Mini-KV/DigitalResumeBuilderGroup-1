package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.CreateProfPage;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.utilities.ExcelUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateProfPageTest extends TestBase{

	CreateProfPage createprof;
	LoginPage login;
	
	@BeforeMethod
	public void login() throws IOException {
		login = new LoginPage(driver);
		String userName = ExcelUtility.readExcel(1,0,"Login");
		String password = ExcelUtility.readExcel(1,1,"Login");
		login.loginMethod(userName,password);
		
		createprof = new CreateProfPage (driver, wait);
		createprof.clickMyProfileLink();
	}

	//check if My profile link is available
	@Test(priority=1, description="verify My profile link")
	public void verifyMyProfileLink() throws IOException {
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, AutomationConstants.expectedMyProfUrl);
	}
		
	//Test Create profile functionality with mandatory fields
	@Test(priority=2, description="verify Create profile functionality")
	public void verifyCreateProfile() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		createprof.clickCreateProfBtn(); 

		String dob =  ExcelUtility.readExcel(1,1,"CreateEditProfile");
		createprof.setDOB(dob);

		String gender =  ExcelUtility.readExcel(1,2,"CreateEditProfile");
		createprof.setGender(gender);

		String highSchQual =  ExcelUtility.readExcel(1,3,"CreateEditProfile");
		String highSchPer =  ExcelUtility.readExcel(1,4,"CreateEditProfile");
		String highSchName =  ExcelUtility.readExcel(1,5,"CreateEditProfile");
		String highSchYear =  ExcelUtility.readExcel(1,6,"CreateEditProfile");
		createprof.setHighSchQual(highSchQual,highSchPer,highSchName,highSchYear);

		String projTitle =  ExcelUtility.readExcel(1,11,"CreateEditProfile");
		String projDesc =  ExcelUtility.readExcel(1,12,"CreateEditProfile");
		createprof.setProject(projDesc,projTitle);
		
		String skills =  ExcelUtility.readExcel(1,13,"CreateEditProfile");
		createprof.setSkills(skills);
		
		String language =  ExcelUtility.readExcel(1,14,"CreateEditProfile");
		createprof.setLanguages(language);
		
		String achmt =  ExcelUtility.readExcel(1,15,"CreateEditProfile");
		createprof.setAchievements(achmt);

		String describe =  ExcelUtility.readExcel(1,16,"CreateEditProfile");
		createprof.setDescribe(describe);
		
		String imgPath =  ExcelUtility.readExcel(1,17,"CreateEditProfile");
		createprof.uploadImage(imgPath);
		
		createprof.clickCreateBtn();
	    Assert.assertEquals(createprof.getAlert(), AutomationConstants.expectedCreateProfText);
		js.executeScript("scroll(0, -250);");
		
	}
		
			
	//Test Edit profile functionality 
	@Test(priority=3, description="verify Edit profile functionality")
	public void verifyEditprofile() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		createprof.clickEditBtn();
	
		String userName =  ExcelUtility.readExcel(2,0,"CreateEditProfile");
		createprof.setUserName(userName);

		String gender =  ExcelUtility.readExcel(2,2,"CreateEditProfile");
		createprof.setGender(gender);
		
		String higherSecQual =  ExcelUtility.readExcel(2,7,"CreateEditProfile");
		String higherSecPer =  ExcelUtility.readExcel(2,8,"CreateEditProfile");
		String higherSecName =  ExcelUtility.readExcel(2,9,"CreateEditProfile");
		String higherSecYear =  ExcelUtility.readExcel(2,10,"CreateEditProfile");
		createprof.setHigherSecQual(higherSecQual,higherSecPer,higherSecName,higherSecYear);
	
		String skills =  ExcelUtility.readExcel(2,13,"CreateEditProfile");
		createprof.setSkills(skills);
	
		String language =  ExcelUtility.readExcel(2,14,"CreateEditProfile");
		createprof.setLanguages(language);
	
		String achmt =  ExcelUtility.readExcel(2,15,"CreateEditProfile");
		createprof.setAchievements(achmt);
	
		String imgPath =  ExcelUtility.readExcel(2,17,"CreateEditProfile");
		createprof.uploadImage(imgPath);

		createprof.clickCreateBtn();
	
		Assert.assertEquals(createprof.getAlert(), AutomationConstants.expectedEditProfText);
		js.executeScript("scroll(0, -250);");
	
	}
		
	
}
