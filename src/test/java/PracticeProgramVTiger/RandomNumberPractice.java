package PracticeProgramVTiger;

import java.util.Random;

import genericUtility.JavaUtility;

public class RandomNumberPractice 
{
	public static void main(String[] args) 
	{
		JavaUtility jut= new JavaUtility();
		 int val1 = jut.getRandomNumber();
		 System.out.println(val1);
		 int val2 = jut.getRandomNumber();
		 System.out.println(val2);
		int res = RandomNumberPractice.add(val1,val2);
	   System.out.println(res);
	}
 	   public static  int  add(int a , int b)
	   {
		   int ans = a + b;
		   return ans;
	   }

}
