package seleniumforestmanagementsystem;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ForestryManagementSystemPage {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver = new ChromeDriver();
	@BeforeMethod
	public  void start() {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void  stop() {
		driver.close();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
