package seleniumforestmanagementsystem;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddProduct extends ForestryManagementSystemPage {
	
	@Test
	public void addProduct() {
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[2]/button/span")).click();
		driver.findElement(By.name("email")).sendKeys("Bhavana@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bhav@123");
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/form/div[3]/button"))
				.click();
		
		driver.findElement(By.xpath("//*[@id=\"client3\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[1]/li[3]/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-product/nav/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"productId\"]")).sendKeys("1050");
		driver.findElement(By.xpath("//*[@id=\"productName\"]")).sendKeys("wood");
		driver.findElement(By.xpath("//*[@id=\"cost\"]")).sendKeys("56465");
		driver.findElement(By.xpath("/html/body/app-root/app-product/app-add-product/div/div/div/div/div/div[2]/form/div[4]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul[2]/li[3]/button/span")).click();
		Reporter.log("Added Product", true);
	}

}
