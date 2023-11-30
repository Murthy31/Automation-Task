package dynamic_Table;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DynamicTable {
	
	WebDriver driver = null;
	WebDriverWait mywait = new WebDriverWait(driver,  Duration.ofSeconds(30));
	SoftAssert softAssert = new SoftAssert();
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void launchbrowser(String browser, String url) throws Exception{
		

		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\chromedriver_win32\\EdgeDriver.exe");
			driver = new EdgeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\snmur\\Downloads\\chromedriver_win32\\GeckoDriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		
		//Maximize the screen
		 driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		 
		Thread.sleep(1000);
	}
     
	
	@Test
	public void test() {
 
		try {
			//wait until the page is loaded fully
			mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//summary[text()='Table Data']")));
			 driver.getTitle().equals("Table HTML Tag - JavaScript Created");
			// Click on Table Data button
			WebElement tableDataButton = driver.findElement(By.xpath("//summary[text()='Table Data']"));
			tableDataButton.click();
			
			// Read test data from JSON file
            JsonNode testData = readTestDataFromJson("C:\\Users\\snmur\\eclipse-workspace\\SDET_Automation_Task\\src\\test\\resources\\TestData\\Data.json");

			// Wait till the input text box is appeared and then enter the json data
			WebElement textBox = mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='jsondata']")));
			textBox.sendKeys(testData.toString());

			// Click on "Refresh Table" button once data is entered in the input text field
			WebElement refreshTableButton = driver.findElement(By.xpath("//button[text()='Refresh Table']"));
			refreshTableButton.click();

			// Get the data from the table
			List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='dynamictable']/tr"));
			
			
			// tableRows is a List<WebElement> containing the rows of the table
			for (int i = 1; i < tableRows.size(); i++) {
			    // Get the text content of the i-th row and split it into an array
			    List<WebElement> columns = tableRows.get(i).findElements(By.xpath("td"));
			    
			  
		        
		        // Get the expected data for the i-th row from the expectedData array
		        String expectedName = testData.get(i - 1).get("name").asText();
                String expectedAge = String.valueOf(testData.get(i - 1).get("age").asInt());
                String expectedGender = testData.get(i - 1).get("gender").asText();

	            // Compare each element in the row with the corresponding element in expectedData
	            softAssert.assertEquals(columns.get(0).getText(), expectedName, "Name mismatch at row " + i);
	            softAssert.assertEquals(columns.get(1).getText(), expectedAge,"Age mismatch at row " + i);
	            softAssert.assertEquals(columns.get(2).getText(), expectedGender,"Gender mismatch at row " + i);
			   
			}

			System.out.println("Dynamic Table functionality has been verified successfully!");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally {
			softAssert.assertAll();
		}
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		// Closes all the instance of the browser
		driver.quit();
	}
	
	private static JsonNode readTestDataFromJson(String filePath) {
        try {
            // Read JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from JSON file", e);
        }
    }
}
