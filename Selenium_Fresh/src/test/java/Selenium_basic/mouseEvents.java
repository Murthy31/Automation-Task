package Selenium_basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseEvents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bigbasket.com/");
        driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R2lmb6:']")).click();
		//        Thread.sleep(2000);
		// Hover over a web element

		Actions act = new Actions(driver);
		WebElement Food_Element = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		//Food_Element.click();
		act.moveToElement(Food_Element).build().perform();
		Thread.sleep(1000);
		WebElement Dry_fruit = driver.findElement(By.xpath("//a[contains(text(),'Dry Fruits')]"));
		act.moveToElement(Dry_fruit).build().perform();
		Thread.sleep(1000);
		WebElement Almond = driver.findElement(By.xpath("//a[contains(text(),'Almonds')]"));
		Almond.click();






		driver.close();

	}

}
