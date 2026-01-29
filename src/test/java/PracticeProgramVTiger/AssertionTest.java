package PracticeProgramVTiger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
@Test
public void demo()
{
	System.out.println("demo1");
	//Assert.assertEquals(true, false);
	System.out.println("demo2");
	SoftAssert sa = new SoftAssert();
	sa.assertEquals('a', 'a');
	//sa.assertEquals("aish", "Aish");
	sa.assertAll();;
}
}
