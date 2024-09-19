package basicTestng;

import org.testng.annotations.Test;

public class OrangeHRM_PIM {
	@Test(priority=1)
	public void create_PIM() {
		System.out.println("PIM is created in OrangeHRM");
		int i=10/0;
	}
	@Test(priority=2, dependsOnMethods = "create_PIM")
	public void update_PIM() {
		System.out.println("PIM is updated in OrangeHRM");
	}
	@Test(priority=3, dependsOnMethods = "create_PIM")
	public void delete_PIM() {
		System.out.println("PIM is deleted in OrangeHRM");
	}
}
/*
* if testng class has multiple @Test method them all methods will be executed alphabetically 
* by default each @Test method priority is set as '0', we can change there priority based on need
* if you have test case depends on another test case execution then user dependsOnMethod


*/