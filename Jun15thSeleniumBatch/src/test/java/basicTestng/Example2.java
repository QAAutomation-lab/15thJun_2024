package basicTestng;

import org.testng.annotations.Test;

public class Example2 {
  @Test
  public void testCase2() {
	  System.out.println("I am TC2");
  }
  
  @Test
  public void testCase1() {
	  System.out.println("I am TC1");
	  calling();
  }
  
  public void calling() {
	  System.out.println("I am calling you...");
  }
}
