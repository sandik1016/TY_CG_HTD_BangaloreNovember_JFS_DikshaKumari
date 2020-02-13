package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InValidLogin extends ForestryManagementSystemPage {

	@Test
	public void InValid() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button/span")).click();
		driver.findElement(By.name("email")).sendKeys("Bhavana@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bhav@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[3]/button"))
				.click();
		Reporter.log("Invalid cerdiantials", true);
	}
}
