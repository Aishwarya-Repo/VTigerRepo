package PracticeProgramVTiger;

import org.testng.annotations.Test;

import genericUtility.BaseClass;

public class TestNGPractice extends BaseClass{

	@Test (invocationCount= 4, priority = 1,groups =  "SmokeExecution")   // @Test (invocationCount= 4, priority = 1,enable = false).....means default value of enable is true but given false so not execute the script
	public void firstTestNGPracticeTest()
	{
		System.out.println("this is first method");
		secondTestNGPracticeTest();
	}
	
	@Test(dependsOnMethods = "firstTestNGPracticeTest")
	public void secondTestNGPracticeTest( )
	{
		System.out.println("this is second method");
	}
	
	@Test
	public void thirdTestNGMethods()
	{
		System.out.println("third is method");
	}
}
