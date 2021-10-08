package org.automationtest.blazedemo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test01 extends properties
{
@Test
	public void TS001() throws IOException, InterruptedException
	{
		myD=BrowserCall();
		//myD.get(properties.getProperty("URL"));
		myD.get("https://blazedemo.com/");
		myD.manage().window().maximize();
		Thread.sleep(2000);
		
String BDT=myD.getTitle();
		
		if(BDT.equalsIgnoreCase("BlazeDemo"))
		{
			System.out.println("Navigated to BlazeDemo Page");
		}
		else
		{
			System.out.println("Invalid Page");
		}
		
		
		
		myD.findElement(By.className("form-inline")).click(); //3.	Choose your Departure city as Boston
		Thread.sleep(4000);
		myD.findElement(By.xpath("/html/body/div[3]/form/select[1]/option[3]")).click();
		Thread.sleep(4000);
		
		myD.findElement(By.name("toPort")).click(); //4. Choose your Destination city as New York
		Thread.sleep(4000);
		myD.findElement(By.xpath("/html/body/div[3]/form/select[2]/option[5]")).click();
		Thread.sleep(4000);
		
		myD.findElement(By.xpath("/html/body/div[3]/form/div/input")).click(); //5.	Click Find Flights
		Thread.sleep(4000);
		
		String reserve=myD.getTitle(); //6.	Validate You have navigated to a Reserve page
		
	       
		if(reserve.equalsIgnoreCase("BlazeDemo - reserve"))
		{
			System.out.println("Navigated to Reserve Page");
		}
		else
		{
			System.out.println("Invalid Page");
		}
		
		myD.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]/input")).click();
		Thread.sleep(4000);
		
        String Purchase=myD.getTitle(); //8.	Validate You have Navigated to a Purchase Page
       
		if(Purchase.equalsIgnoreCase("BlazeDemo Purchase"))
		{
			System.out.println("Navigated to Purchase Page");
		}
		else
		{
			System.out.println("Invalid");
		}
		
		
		myD.findElement(By.id("inputName")).sendKeys("Nikhil");
		myD.findElement(By.id("creditCardNumber")).sendKeys("706919458004");
		myD.findElement(By.id("nameOnCard")).sendKeys("Nikhil B K");
		myD.findElement(By.id("rememberMe")).click();
		myD.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
		Thread.sleep(5000);
		
        String Confirmation=myD.getTitle();
		
		if(Confirmation.equalsIgnoreCase("BlazeDemo Confirmation"))
		{
			System.out.println("Navigated to Confirmation Page");
		}
		else
		{
			System.out.println("Invalid Page");
		}
		
		String Amount= myD.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[3]/td[2]")).getText();
		System.out.println("The Amount = "+Amount);
		
		String CardNumber= myD.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[4]/td[2]")).getText();
		System.out.println("CardNumber = "+CardNumber);
		
		String Expiration= myD.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[5]/td[2]")).getText();
		System.out.println("Expiration = "+Expiration);
		
		myD.close();

}

}
