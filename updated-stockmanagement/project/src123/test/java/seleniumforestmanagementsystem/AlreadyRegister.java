package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AlreadyRegister extends ForestryManagementSystemPage {

	@Test
	public void alreadyRegister() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[1]/button/span")).click();
		driver.findElement(By.name("name")).sendKeys("chandrika");
		driver.findElement(By.name("email")).sendKeys("chandrika@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Chandrika@123");
		driver.findElement(By.name("id")).sendKeys("1234");
		driver.findElement(By.name("phoneNumber")).sendKeys("8786786778");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Admin");
		driver.findElement(By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/form/div[7]/button"))
				.click();
		Reporter.log("Already registered", true);
	}
}
