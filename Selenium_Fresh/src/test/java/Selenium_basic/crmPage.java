package Selenium_basic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class crmPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.zoho.com/crm/free-crm.html");
		driver.manage().window().maximize();

		// Navigate to the Zoho CRM page
		//WebDriverWait wait = new WebDriverWait(driver, 10);


		// Click on the "Testimonials" link
		//WebElement testimonialsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(By.xpath("//a[contains(text(),'Testimonials')]"))));
		//testimonialsLink.click();

		// Wait for the testimonials page to load
		// You can use the WebDriverWait class to wait for specific elements to appear on the page
		// For example, you can wait for the "Customer Stories" section to appear:
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement customerStoriesSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Customer Stories')]")));

		// Close the browser
		driver.quit();
	}
}



