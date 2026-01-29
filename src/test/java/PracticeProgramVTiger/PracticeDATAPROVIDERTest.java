package PracticeProgramVTiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDATAPROVIDERTest 
{
@Test(dataProvider = "ContactData")
	public void getContactDataTest(String TC_ID	, String FirstName, String LastName, String LeadSource, String OrgName)
	{
		System.out.println("ID : "+TC_ID+" FirstName :"+ FirstName+" LastName: "+ LastName+" LeadSource :"+ LeadSource+" OrgName :"+ OrgName);
	}


@DataProvider(name="ContactData")
public Object[][] getData()
{
	Object[][] data = new Object[4][5];
	data[0][0]="TC_01";
	data[0][1]="Aishwarya";
	data[0][2]="Patil";
	data[0][3]="Employee";
	data[0][4]="Wipro";
	
	data[1][0]="TC_02";
	data[1][1]="Rohan";
	data[1][2]="Patil";
	data[1][3]="Partner";
	data[1][4]="Infosys";
	
	data[2][0]="TC_03";
	data[2][1]="Sneha";
	data[2][2]="Kulkarni";
	data[2][3]="Web Site";
	data[2][4]="TCS";
	
	data[3][0]="TC_04";
	data[3][1]="Rahul";
	data[3][2]="Jadhav";
	data[3][3]="Cold Call";
	data[3][4]="Accenture";
	
	return data;
}
}








