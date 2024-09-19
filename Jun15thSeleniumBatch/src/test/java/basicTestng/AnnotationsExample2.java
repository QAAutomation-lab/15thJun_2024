package basicTestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AnnotationsExample2 {
  @Test(priority=1)
  public void createPIM() {
	  System.out.println("ORANGEHRM PIM is created...");
  }
  @Test(priority=2)
  public void updatePIM() {
	  System.out.println("ORANGEHRM PIM is updated...");
  }
  @Test(priority=3)
  public void deletePIM() {
	  System.out.println("ORANGEHRM PIM is delete...");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("******************BEFORE_METHOD--LoginAndNavigateToPIM**************************");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("******************AFTER_METHOD---Logout**************************");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("******************BEFORE_TEST---Open Browser**************************");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("******************AFTER_TEST---Close Browser**************************");
	  
  }

}

/*
 * Launch Application ---> @BeforeTest
 * 		login and navigate to PIM page ---> @BeforeMethod
 * 			TC1: create PIM
 * 		logout ---> @AfterMethod
 * 
 * 		login and navigate to PIM page ---> @BeforeMethod
 * 		 	TC2: update PIM
 * 		logout ---> @AfterMethod
 * 
 *		login and navigate to PIM page
 * 		 	TC3: delete PIM
 * 		logout ---> @AfterMethod
 * Close the application ---> @AfterTest
 */
