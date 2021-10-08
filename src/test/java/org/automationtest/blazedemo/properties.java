package org.automationtest.blazedemo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class properties
{
	
	
	public WebDriver myD;
	Properties properties;
	
	@Test
	
	public WebDriver BrowserCall() throws IOException
	{
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\00004992\\Desktop\\Automation\\blazedemo\\data.properties");
		properties.load(fis);
		String vBrowser=properties.getProperty("Browser");
		
		if(vBrowser.equalsIgnoreCase("Chrome"))
		{
			System.out.println("Chrome browser is started");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\00004992\\Desktop\\Automation\\chromedriver.exe");
			
			myD=new ChromeDriver();
		}
		else if(vBrowser.equalsIgnoreCase("Edge"))
		{
			System.out.println("Edge browser is started");
			System.setProperty("webdriver.edge.driver","C:\\Users\\00004992\\Desktop\\Automation\\msedgedriver.exe");
			
			myD=new EdgeDriver();
		}
		else
		{
			System.out.println("Some other browser is started");
		}
		return myD;

		}
	
	    	}


