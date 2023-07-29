package org.ictkerala.pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProfPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public WebElement createProfBtn;
	public WebElement myProfileLink;
	public WebElement editProfBtn;
	public WebElement deleteProfBtn;
	public WebElement createBtn;
	public WebElement userName ;
	public WebElement dateOfBirth ;
	public WebElement highSchQual ;
	public WebElement highSchPer ;
	public WebElement highSchName ;
	public WebElement highSchYear ;
	public WebElement higherSecQual ;
	public WebElement higherSecPer ;
	public WebElement higherSecName ;
	public WebElement higherSecYear ;
	List<WebElement> gender ;
	public WebElement skill ;
	public WebElement addSkillBtn;
	public WebElement language ;
	public WebElement addLangBtn;
	public WebElement describe;
	public WebElement image;
	public WebElement projectTitle;
	public WebElement addAchmtBtn;
	public WebElement Achmt;	
	public WebElement projectDesc;
	public WebElement addProjBtn;
	public String profAlertText;

	
	public CreateProfPage (WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	//click on Create profile button 
	public void clickCreateProfBtn() {
		createProfBtn = driver.findElement(By.xpath("//button[contains(text(),'Create a Profile Now')]"));
		createProfBtn.click();
	}
	
	//click on My profile link 
	public void clickMyProfileLink() {
		myProfileLink = driver.findElement(By.xpath("//a[text()='My Profile']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", myProfileLink);
		js.executeScript("arguments[0].click();", myProfileLink);
	}
		
	//Click Edit profile button
	public void clickEditBtn() {
		editProfBtn = driver.findElement(By.xpath("//a[text()='Edit Profile']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", editProfBtn);
		js.executeScript("arguments[0].click();", editProfBtn);
	}	
		
	//Click Delete profile button
	public void clickDelBtn() {
		deleteProfBtn = driver.findElement(By.xpath("//a[text()='Delete Profile']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", deleteProfBtn);
		js.executeScript("arguments[0].click();", deleteProfBtn);
		}	
	
	//Click Create profile button
	public void clickCreateBtn() {
		createBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", createBtn);
		js.executeScript("arguments[0].click();", createBtn);
	}	
	
	//Get alert
	public String getAlert() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert profAlert = driver.switchTo().alert();
		profAlertText = profAlert.getText();	
		profAlert.accept();
		return profAlertText;		
	}	
	
	
	//Set username
	public void setUserName(String inpName) {
		userName = driver.findElement(By.id("name"));
		userName.clear();
		userName.sendKeys(inpName);
	}
		
	//Set DOB
	public void setDOB(String inpDOB) {
		dateOfBirth = driver.findElement(By.id("date"));
		dateOfBirth.clear();
		dateOfBirth.sendKeys(inpDOB);
	}
	
	//Set Gender
	public void setGender(String inpGender) {
		gender = driver.findElements(By.id("gender"));
		if (inpGender.equals("Male")){
			gender.get(0).click();
		}
		else if (inpGender.equals("Female")){
			gender.get(1).click();
		}	
	}
	
	//Set high school qualifications
	public void setHighSchQual(String inpQual, String inpPer, String inpSchool,String inpYear) {
		highSchQual = driver.findElement(By.id("edu_title"));
		highSchQual.sendKeys(inpQual);
		highSchPer = driver.findElement(By.id("edu_desc"));
		highSchPer.sendKeys(inpPer);
		highSchName = driver.findElement(By.id("edu_school"));
		highSchName.sendKeys(inpSchool);
		highSchYear = driver.findElement(By.id("edu_year"));
		highSchYear.sendKeys(inpYear);		
	  }	
	
	//Set higher secondary qualifications
	public void setHigherSecQual(String inpQual, String inpPer, String inpSchool,String inpYear) {		
		higherSecQual = driver.findElement(By.xpath("//p[@formgroupname='higherschools']//descendant::select"));
		higherSecQual.sendKeys(inpQual);
		higherSecPer = driver.findElement(By.xpath("//p[@formgroupname='higherschools']//descendant::input[@placeholder='Percentage Scored']"));
		higherSecPer.sendKeys(inpPer);
		higherSecName = driver.findElement(By.xpath("//p[@formgroupname='higherschools']//descendant::input[@placeholder='School Name']"));
		higherSecName.sendKeys(inpSchool);
		higherSecYear = driver.findElement(By.xpath("//p[@formgroupname='higherschools']//descendant::input[@placeholder='Year of Pass']"));
		higherSecYear.sendKeys(inpYear);
	}
	
	//Set project 
	public void setProject(String inpTitle,String inpDesc ) {		
		addProjBtn = driver.findElement(By.xpath("//th[text() ='Add Your Projects:']//following::button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", addProjBtn);
		js.executeScript("arguments[0].click();", addProjBtn);
		projectTitle = driver.findElement(By.xpath("//td[text()=' Project title : ']//descendant::input[@formcontrolname='title']"));
		projectTitle.clear();
		projectTitle.sendKeys(inpTitle);
		projectDesc = driver.findElement(By.xpath("//td[text()=' Description: ']//descendant::input[@formcontrolname='desc']"));
		projectDesc.clear();
		projectDesc.sendKeys(inpDesc);
	}
		

	//Set skills
	public void setSkills(String inpSkill) {
		addSkillBtn = driver.findElement(By.xpath("//th[text() ='Your Skills:']//following::button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", addSkillBtn);
		js.executeScript("arguments[0].click();", addSkillBtn);
		skill = driver.findElement(By.xpath("//input[@formcontrolname ='skills']"));
		skill.clear();
		skill.sendKeys(inpSkill);
	}
	
	//Set languages
	public void setLanguages(String inpLanguage) {
		addLangBtn = driver.findElement(By.xpath("//th[text() ='Languages Known:']//following::button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", addLangBtn);
		js.executeScript("arguments[0].click();", addLangBtn);
		language = driver.findElement(By.xpath("//input[@formcontrolname ='languages']"));
		language.clear();
		language.sendKeys(inpLanguage);
	}
	
	//Set achievements
	public void setAchievements(String inpAchmt) {
		addAchmtBtn = driver.findElement(By.xpath("//th[text() ='Your achievements:']//following::button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", addAchmtBtn);
		js.executeScript("arguments[0].click();", addAchmtBtn);
		Achmt = driver.findElement(By.xpath("//input[@formcontrolname ='achievements']"));
		Achmt.clear();
		Achmt.sendKeys(inpAchmt);
	}
	
	//Set describe yourself
	public void setDescribe(String inpDescribe) {
		describe = driver.findElement(By.id("yourself"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", describe);
		describe.clear();
		describe.sendKeys(inpDescribe);
	}
	
	//Upload image
	public void uploadImage(String inpImagePath) {
		image = driver.findElement(By.name("image"));
		image.sendKeys(inpImagePath);
	}
		
}
