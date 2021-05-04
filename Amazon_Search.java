package com.qa.amazon;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Amazon_Search {
	
	WebDriver driver;	
	@BeforeClass
	public void setUp()
	{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanjana\\AndroidStudioProjects\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
	}
@AfterClass
public void tearDown()
{
driver.close();
}

@Test(priority=1)
public void Input(String ip1,String ip2) throws InterruptedException
{
	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobile");
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Fashion");
	driver.findElement(By.id("nav-search-submit-button")).click();
}

@Test(priority=2)
public void Failed()
{
	if(driver.getTitle().contains("Amazon"))
	Assert.assertTrue(false, "false");
}

//@DataProvider(name="DataSource")
//public String[][] supplyData() throws IOException{
//	String xlPath="C:\\Users\\sanjana\\eclipse-workspace\\Sel_Testng\\Sanjana_01\\src\\test\\java\\com\\qa\\amazon\\TestData.xlsx";
//	String xlSheet = "Sheet1";
//	
//	int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
//	
//	int cellCount= ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
//	
//	String[][] data=new String[rowCount][cellCount];
//	
//	for (int i = 1; i <= rowCount; i++) {
//		for (int j = 0; j < cellCount; j++) {
//			data[i-1][j] = ExcelUtility.getcellData(xlPath, xlSheet, i, j);
//
//		}
//	}
//
//	return data;
//	
//}
}