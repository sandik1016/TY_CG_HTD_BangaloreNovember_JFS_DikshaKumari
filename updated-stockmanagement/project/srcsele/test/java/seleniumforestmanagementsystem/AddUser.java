package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddUser extends ForestryManagementSystemPage {

	@Test
	public void addUser() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button/span")).click();
		driver.findElement(By.name("email")).sendKeys("Bhavana@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bhav@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[3]/button"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"admin1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[1]")).click();
		driver.findElement(By.name("name")).sendKeys("gopi");
		driver.findElement(By.name("email")).sendKeys("gopi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Gopi@123");
		driver.findElement(By.name("id")).sendKeys("1265");
		driver.findElement(By.name("phoneNumber")).sendKeys("8242781285");
		Select role = new Select(driver.findElement(By.name("role")));
		role.selectByVisibleText("Scheduler");
		driver.findElement(By.xpath("/html/body/app-root/app-add-user/div/div/div/div/div/div[2]/form/div[7]/button"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button/span")).click();
		Reporter.log("Added Client", true);
	}
}
