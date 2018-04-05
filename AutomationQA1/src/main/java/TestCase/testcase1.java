package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import Library.LoginLib;
import WebElement.Login;

public class testcase1 {
boolean b1= false;
	@Test
	public void test1()
	{
		System.out.println("buyer");
		System.out.println(Login.str);
		Assert.assertEquals(LoginLib.login("a", "a"), true);
		

}
	@Test
	public void test2()
	{
		System.out.println("sup");
		LoginLib.login("a", "a");

}
	@Test
	public void tes3()
	{
		System.out.println("st");
		LoginLib.login("a", "a");

}
	@Test
	public void test4()
	{
		System.out.println("omd");
		LoginLib.login("a", "a");
		

}
}
