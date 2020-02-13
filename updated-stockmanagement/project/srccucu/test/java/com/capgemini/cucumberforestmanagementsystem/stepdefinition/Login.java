package com.capgemini.cucumberforestmanagementsystem.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;

	@Before
	public void openBrowser() {
		driver = new ChromeDriver();

	}

	@When("^Enter valid email and password$")
	public void enter_valid_email_and_password() throws Throwable {
		driver.get("http://localhost:4200");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button/span")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Bhavana@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Bhav@123");
	}

	@When("^Click on the Login$")
	public void click_on_the_Login() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[3]/button")).click();
	}

	@When("^Click the Logout button$")
	public void click_the_Logout_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button/span")).click();
	}

	@Then("^Close the driver$")
	public void close_the_driver() throws Throwable {
		driver.close();
	}
	
}
