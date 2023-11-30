package Selenium_basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bigbasket.com/");
        driver.manage().window().maximize();
        
        List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='w-1/3 pr-4']//ul/li/a"));
        
        System.out.println("List of footer links ");
        for(int i=0;i<footerLinks.size();i++) {
        	System.out.println(footerLinks.get(i).getText());
        }
        //click on first element
        footerLinks.get(0).click();
        driver.close();

	}

}
