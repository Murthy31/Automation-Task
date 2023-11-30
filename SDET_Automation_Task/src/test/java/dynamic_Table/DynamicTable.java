package dynamic_Table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Create a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();

		// Navigate to the given URL
		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

		try {
			// Step 2: Click on Table Data button
			WebElement tableDataButton = driver.findElement(By.id("table-data-page"));
			tableDataButton.click();

			// Step 3: Insert data in the input text box and click Refresh Table button
			String jsonData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, "
					+ "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, "
					+ "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, "
					+ "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, "
					+ "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";

			WebElement inputTextBox = driver.findElement(By.id("data"));
			inputTextBox.sendKeys(jsonData);

			WebElement refreshTableButton = driver.findElement(By.id("load"));
			refreshTableButton.click();

			// Step 4: Get the data from the UI table
			List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table']//tbody/tr"));

			// Step 5: Assert the entered data with the data in the UI table
			for (int i = 0; i < tableRows.size(); i++) {
				String[] rowData = tableRows.get(i).getText().split("\\s+");
				String expectedData = jsonData.split("\\s+")[i];
				assert rowData[0].equals(expectedData) : "Data mismatch at row " + (i + 1);
			}

			System.out.println("Automation script executed successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser window
			driver.quit();
		}
	}
}
