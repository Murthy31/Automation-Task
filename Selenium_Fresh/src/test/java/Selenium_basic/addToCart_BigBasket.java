package Selenium_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class addToCart_BigBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\Selenium Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();

		// navigate to the website
		driver.get("https://www.bigbasket.com/");

		// find the search box and enter "fresheners & repellents"
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='input']"));
		searchBox.sendKeys("fresheners & repellents\n");

		// wait for the search results to load
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement results = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@qa='product_list_container']")));

		// select the first item from the search results and click on it
		WebElement item = driver.findElement(By.xpath("//div[@qa='product_list_container']//div[@qa='product_name'][1]"));
		item.click();

		// wait for the product page to load
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='GrE04']")));

		// increase the quantity of the product to 2
		WebElement quantity = driver.findElement(By.xpath("//input[@class='input-text qty']"));
		quantity.clear();
		quantity.sendKeys("2");

		// add the product to the cart
		WebElement addToCart = driver.findElement(By.xpath("//button[@qa='add_button']"));
		addToCart.click();

		// wait for the product to be added to the cart
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@qa='cart_button']")));

		// navigate back to the search results page
		driver.navigate().back();

		// select the second item from the search results and click on it
		item = driver.findElement(By.xpath("//div[@qa='product_list_container']//div[@qa='product_name'][2]"));
		item.click();

		// wait for the product page to load
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='GrE04']")));

		// increase the quantity of the product to 3
		quantity = driver.findElement(By.xpath("//input[@class='input-text qty']"));
		quantity.clear();
		quantity.sendKeys("3");

		// add the product to the cart
		addToCart = driver.findElement(By.xpath("//button[@qa='add_button']"));
		addToCart.click();

		// wait for the product to be added to the cart
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@qa='cart_button']")));

		// navigate to the cart page
		WebElement cartButton = driver.findElement(By.xpath("//div[@qa='cart_button']"));
		cartButton.click();

		// wait for the cart page to load
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@qa='cart_title']")));

		// close the browser
		driver.quit();
	}

}
