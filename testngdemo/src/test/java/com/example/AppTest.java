package com.example;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    // @BeforeTest
    // public void beforetest(){
    //     System.out.println("Before the test");
    // }
    @BeforeMethod
    public void beforemethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
    }
    
    @Test(priority = 0)
    public void shouldAnswerWithTrue() throws Exception
    {
        FileInputStream fs=new FileInputStream("C:\\dbankdemo.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fs);
        XSSFSheet login=workbook.getSheet("login");
        XSSFRow r1=login.getRow(1);
        String username=r1.getCell(0).getStringCellValue();

        Thread.sleep(5000);
        // driver.findElement(By.id("username")).sendKeys("S@gmail.com");
        // driver.findElement(By.id("password")).sendKeys("P@ssword12");
        // driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        System.out.println(username);
        
    }
    // @Test(priority = 1)
    // public void shouldAnswer()
    // {
    //     driver.get("https://www.bing.com/");
    //     System.out.println("Test 2 executed");
        
    // }
   
    // @AfterTest
    // public void aftertest(){
    //     System.out.println("After the test");
    // }
    @AfterMethod
    public void aftermethod(){
        driver.quit();
        System.out.println("After the method");
    }
}
