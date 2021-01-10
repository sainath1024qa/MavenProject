package com.prova.SainathMaven;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest extends TestData
{

	public HomePageTest()
	{
		this.d=null;
		this.counter1=0;
		
	}

	 WebDriver d;
	int counter1;		

	@Before
	public  void instantiateBrowser() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\srinath\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		
		if (d==null)
			d = new ChromeDriver();
		
		// System.setProperty("webdriver.chrome.whitelistedIps","" );
	}

	@After
	public void quit()
	{
		d.close();
		d.quit();	
	}
	
//	@Test
//	public void testSuite1( ) 
//	{
//		this.validatePageLoad(d);
//		this.valdiateHeaderMenuItems(d);
//		this.validateLeftMenuItems(d);
//		
//	}
	@Test
	 public void test1() 
	 {
		this.validatePageLoad(d);

	 }
	@Test
	 public void test2() 
	 {
		try {
			this.valdiateHeaderMenuItems(d);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	
	 public void test3() 
	 {
		this.validateLeftMenuItems(d);

	 }

	public void validatePageLoad(WebDriver driver)
	{
		driver.navigate().to("https://www.geeksforgeeks.org/");
		WebElement e=driver.findElement(By.cssSelector("div.header-main__container li:nth-of-type(1)"));
		System.out.println("Found the element-getting text");
		String s=e.getText();
		System.out.println("Found the element-text acquired");

		if(s.contains("Tutorials"))//   compareToIgnoreCase("tutorials")==0) 
		{
			System.out.println("Page loaded, Tutorials menu item found");
		}
	}
	
	
	public void valdiateHeaderMenuItems(WebDriver driver) throws InterruptedException
	{
		driver.navigate().to("https://www.geeksforgeeks.org/");	
		int counter=0;
		List<WebElement> headerelements= driver.findElements(By.cssSelector("li.header-main__list-item"));
		
		
		if(headerelements.size()==this.HearderElements.size()) 
		{
			System.out.println("No. of elements matched with the expectation");
		}
		
			
		for(WebElement w: headerelements)
		{
			String[] s =w.getText().split("\n");
			
		
			if(HearderElements.contains(s[0])) 
			{
				System.out.println(s[0]+"  element found");
				counter++;
			}
			
		}
		
		if(counter==4)
		{
			System.out.println("----All the 4 Header elements Verified---");
		}

	}
	
	public void validateLeftMenuItems(WebDriver driver) 
	{
		List<WebElement> elements= driver.findElements(By.cssSelector(".leftbar-dropdown"));
		for(WebElement w:elements) 
		{
			String[] s =w.getText().split("\n");
			
			
			if(this.LeftPaneElements.contains(s[0])) 
			{
				System.out.println(s[0]+"  element found");
				this.counter1++;
			}
		}
		
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/c/?ref=leftbar']");//,this.counter1);
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/c-plus-plus/?ref=leftbar']");//,this.counter1);
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/java/?ref=leftbar']");//,this.counter1);
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/python-programming-language/?ref=leftbar']");//,this.counter1);
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/machine-learning/']");//,this.counter1);
		isPresentinLeftPaneElements(driver,"li a[href='https://www.geeksforgeeks.org/puzzles/']");//,this.counter1);
		
			
			if(this.counter1==19)
			{
				System.out.println("---All 19 left pane menu items verified");
			}
			else 
			{
				System.out.println("***19 not verified");
				System.out.println(this.counter1);
			}
	
	}
	
	public void isPresentinLeftPaneElements(WebDriver driver, String s) 
	{

		WebElement e = driver.findElement(By.cssSelector(s));
			if(LeftPaneElements.contains(e.getText())) 
			{
				System.out.println(e.getText()+"  element found");
				this.counter1++;
			}	
	}
	
	
}
