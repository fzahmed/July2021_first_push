package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTest {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}

	@Before
	public void launchBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\fahme\\july2021_selinum\\Session1\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	// @Test
	public void NegativeloginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		//driver.findElement(By.className(btn btn-success block full-width))
		Thread.sleep(3000);
	}

	//@After
	public void tearDown() {
		System.out.println("tear down");
		// driver.close();
		driver.quit();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}

}
