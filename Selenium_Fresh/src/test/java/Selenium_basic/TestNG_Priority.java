package Selenium_basic;

import org.testng.annotations.Test;

public class TestNG_Priority {
  @Test
  public void fost() {
	  System.out.println(" In Foster ");
  }
  
  @Test(priority = -1)
  public void apple() {
	  System.out.println(" In Apple ");
  }
  
  @Test(priority = -1)
  public void xpple() {
	  System.out.println(" In Xpple ");
  }
  
  @Test(priority=0, dependsOnMethods="fost")
  public void aost() {
	  System.out.println(" In aost ");
  }
  
  
}
