package basicTestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("***************BEFORE_SUITE*************************");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("***************AFTER_SUITE*************************");
  }

}
