package com.capgemini.cucumberforestmanagementsystem.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class Register {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;

	@Before
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	@When("^Click on the Register$")
	public void click_on_the_Register() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/nav/div/ul[2]/li[1]/button/span")).click();
	}

	@When("^Add the UserData$")
	public void add_the_UserData() throws Throwable {
		driver.findElement(By.name("name")).sendKeys("sam");
		driver.findElement(By.name("email")).sendKeys("sam@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Sam@123");
		driver.findElement(By.name("id")).sendKeys("934");
		driver.findElement(By.name("phoneNumber")).sendKeys("8126778778");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Admin");
	}

	@When("^Click on the Add User button$")
	public void click_on_the_Add_User_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/form/div[7]/button"))
		.click();
	}

	@When("^Click on logout$")
	public void click_on_logout() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button/span")).click();
		driver.close();
	}
}
