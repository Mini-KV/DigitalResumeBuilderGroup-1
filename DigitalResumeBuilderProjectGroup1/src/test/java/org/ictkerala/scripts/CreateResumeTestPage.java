package org.ictkerala.scripts;

import java.io.IOException;

import org.ictkerala.constants.AutomationConstants;
import org.ictkerala.pages.CreateProfPage;
import org.ictkerala.pages.CreateResumePage;
import org.ictkerala.pages.LoginPage;
import org.ictkerala.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * @author Mini
 */
public class CreateResumeTestPage extends TestBase{
	
	CreateResumePage createres;
	CreateProfPage createprof;
	LoginPage login;
	
	@BeforeMethod
	public void login() throws IOException {
		login = new LoginPage(driver);
		String userName = ExcelUtility.readExcel(1,0,"Login");
		String password = ExcelUtility.readExcel(1,1,"Login");
		login.loginMethod(userName,password);
		
		createres = new CreateResumePage(driver);
		createres.clickCrtResumeBtn();
		}


	//Test resume creation with template 1 when profile is already created
	@Test(priority=1, description= "Verify Resume creation template1")
	public void verifyCreateResTemp1() throws InterruptedException  {		
		Assert.assertEquals(createres.getTemplate1(), AutomationConstants.expectedTemp1Title);
	}


	//Test resume creation with template 2 when profile is already created
	@Test(priority=2, description= "Verify Resume creation template2")
	public void verifyCreateResTemp2() throws InterruptedException  {
		Assert.assertEquals(createres.getTemplate2(), AutomationConstants.expectedTemp2Title);
	}

	//Test resume creation with template 3 when profile is already created
	@Test(priority=3, description= "Verify Resume creation template3")
	public void verifyCreateResTemp3() throws InterruptedException  {
		Assert.assertEquals(createres.getTemplate3(), AutomationConstants.expectedTemp3Title);
	}
	
	//Test resume creation with template 4 when profile is already created
	@Test(priority=4, description= "Verify Resume creation template4")
	public void verifyCreateResTemp4() throws InterruptedException {
		Assert.assertEquals(createres.getTemplate4(), AutomationConstants.expectedTemp4Title);
	}
	
	//Test if edit profile button is opening with template 1
	@Test(priority=5, description= "Verify Edit button")
	public void editDetails() throws InterruptedException {
		createprof = new CreateProfPage (driver, wait);
		createres.getTemplate1();
		createres.clickEditBtnTemp1();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, AutomationConstants.expectedEditProfUrl);
		}
	
	//Test download with template 2
	@Test(priority=6, description= "Verify Download resume1")
	public void verifyDownloadResume() throws InterruptedException {
		createprof = new CreateProfPage (driver, wait);
		createres.getTemplate2();
		createres.clickDownloadTemp2();
		Assert.assertEquals(createprof.getAlert(), AutomationConstants.expectedDownloadText);
	}
	
	//Test web link creation with template 2	
	@Test(priority=7, description= "Verify Weblink")
	public void verifyWebLink() throws IOException, InterruptedException {
		createprof = new CreateProfPage (driver, wait);
		createres.getTemplate2();
		createres.clickWeblinkTemp2();
		Assert.assertEquals(createprof.getAlert(), AutomationConstants.expectedLinkText);
	}
	
	//Test Delete profile button
	@Test(priority=8, description="verify Delete profile page")
	public void verifyDeleteprofile() throws IOException {
		createprof = new CreateProfPage(driver,wait);
		createprof.clickMyProfileLink();
		createprof.clickDelBtn();
		Assert.assertEquals(createprof.getAlert(), AutomationConstants.expectedDelProfText);
	}

}
