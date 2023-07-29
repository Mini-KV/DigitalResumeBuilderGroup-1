package org.ictkerala.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CreateResumePage {
	
	WebDriver driver;
	
	public WebElement createResumeBtn;
	public WebElement clickTemplLink;
	public WebElement template1;	
	public WebElement template2;
	public WebElement template3;
	public WebElement template4;
	public WebElement template5;
	public WebElement downloadBtn;
	public WebElement webLinkBtn;
	public WebElement editBtn;
	public WebElement template1Page;

	String template1PageText;
	String template2PageText;
	String template3PageText;
	String template4PageText;
	String template5PageText;
	
	public CreateResumePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCrtResumeBtn() {
		createResumeBtn = driver.findElement(By.xpath("//a[contains(.,'Create your resume now')]"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", createResumeBtn);
		js.executeScript("arguments[0].click();", createResumeBtn);
	}
	

	public String getTemplate1() throws InterruptedException  {
		template1 = driver.findElement(By.xpath("//div[text()='OREON BLUE']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", template1);
		js.executeScript("arguments[0].click();", template1);
		template1PageText = driver.findElement(By.xpath("//div[@class='pg-title']")).getText();
		return template1PageText;
	}
	
	public String getTemplate2() throws InterruptedException {
		template2 = driver.findElement(By.xpath("//div[text()='MULBERRY WHITE']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", template2);
		js.executeScript("arguments[0].click();", template2);
		template2PageText = driver.findElement(By.xpath("//h3[contains(., 'Career Description')]")).getText();
		return template2PageText;
	}
	
	public String getTemplate3() throws InterruptedException {
		template3 = driver.findElement(By.xpath("//div[text()='NOVA PEACH']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", template3);
		js.executeScript("arguments[0].click();", template3);
		template3PageText = driver.findElement(By.xpath("//h2[contains(., 'Career Profile')]")).getText();
		return template3PageText;
	}
	
	public String getTemplate4() throws InterruptedException {
		template4 = driver.findElement(By.xpath("//div[text()='PEARL BLISS']"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", template4);
		js.executeScript("arguments[0].click();", template4);
		template4PageText = driver.findElement(By.xpath("//span[contains(., 'Eduation')]")).getText();
		return template4PageText;
	}
	
	
	public void clickDownloadTemp2() throws InterruptedException {
		downloadBtn = driver.findElement(By.xpath("//button[contains(.,'Download')]"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", downloadBtn);
		js.executeScript("arguments[0].click();", downloadBtn);
	}

	public void clickWeblinkTemp2() throws InterruptedException {
		webLinkBtn = driver.findElement(By.xpath("//button[contains(.,'Weblink')]"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView;", webLinkBtn);
		js.executeScript("arguments[0].click();", webLinkBtn);
	}
	
	public void clickEditBtnTemp1() {
		editBtn = driver.findElement(By.xpath("//a[contains(.,'Edit details')]"));
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView;", editBtn);
		js.executeScript("arguments[0].click();", editBtn);
	}
}
