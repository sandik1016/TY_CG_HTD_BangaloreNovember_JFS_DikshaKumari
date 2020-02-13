package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteUser extends ForestryManagementSystemPage {

	@Test
	public void deleteUser() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button/span")).click();
		driver.findElement(By.name("email")).sendKeys("Bhavana@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bhavana@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[3]/button"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"admin1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[1]/div/a[2]")).click();

		driver.findElement(By.xpath("/html/body/app-root/app-getall-users/div/div/table/tbody/tr[1]/td[6]/img"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button/span")).click();
		Reporter.log("User deleted", true);
	}

}
