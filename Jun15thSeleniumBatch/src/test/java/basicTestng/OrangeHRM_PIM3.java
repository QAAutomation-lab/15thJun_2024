package basicTestng;

import org.testng.annotations.Test;

public class OrangeHRM_PIM3 {
	@Test(priority=1, invocationCount=3)
	public void create_PIM() {
		System.out.println("PIM is created in OrangeHRM");
	}
	@Test(priority=2, dependsOnMethods = "create_PIM", timeOut = 2000)
	public void update_PIM() throws InterruptedException {
		System.out.println("PIM is updated in OrangeHRM");
		Thread.sleep(1500);
	}
	@Test(priority=3, dependsOnMethods = "create_PIM", expectedExceptions = ArithmeticException.class)
	public void delete_PIM() {
		System.out.println("PIM is deleted in OrangeHRM");
		int i=10/0;
		System.out.println("Deleted successfully...");
	}
}
/*
* if testng class has multiple @Test method them all methods will be executed alphabetically 
* by default each @Test method priority is set as '0', we can change there priority based on need
* if you have test case depends on another test case execution then user dependsOnMethod
* if you want to execute same method multiple times then use "invocationCount"

*/