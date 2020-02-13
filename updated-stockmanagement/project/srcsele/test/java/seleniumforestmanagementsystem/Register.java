package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Register extends ForestryManagementSystemPage {

	@Test
	public void register() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]/button/span")).click();
		driver.findElement(By.name("name")).sendKeys("john");
		driver.findElement(By.name("email")).sendKeys("john@gmail.com");
		driver.findElement(By.name("password")).sendKeys("John@123");
		driver.findElement(By.name("id")).sendKeys("12");
		driver.findElement(By.name("phoneNumber")).sendKeys("8126778778");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Admin");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/form/div[7]/button"))
				.click();
		Reporter.log("register successfull", true);
	}
}
