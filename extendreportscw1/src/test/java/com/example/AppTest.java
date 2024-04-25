package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://groww.in/");
        driver.manage().window().maximize();
        report=new ExtentReports();
    }
    // public void screenshot() throws Exception
    // {
    // }
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
        test=report.createTest("Take ScreenShot");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,500)");
        driver.findElement(By.linkText("Calculators")).click();
        
        Thread.sleep(5000);
        WebElement heading=driver.findElement(By.xpath("//*[@id='root']/div[2]/h1"));
        String s=heading.getText();
        if(s.equals("Calculators"))
        {
            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String path="C:\\Users\\subas\\Documents\\softwaretesingcw\\extendreportscw1\\src\\screenshot.png";
            FileUtils.copyFile(screenshot, new File(path));
            test.addScreenCaptureFromPath(path);
            System.out.println("Message present");
        }
        else{
            System.out.println("Message not present");
        }
        js.executeScript( "window.scrollBy(0,1000)");
        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]/div/p[1]")).click();
        Thread.sleep(5000);
        WebElement amount= driver.findElement(By.xpath("//*[@id='LOAN_AMOUNT']"));
        amount.clear();

        FileInputStream fs = new FileInputStream("C:\\Users\\subas\\Downloads\\growwin.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet login = workbook.getSheet("calculator");
        XSSFRow r1 = login.getRow(1);
        int loan =(int) r1.getCell(0).getNumericCellValue();
        int  rateOfInterest= (int) r1.getCell(1).getNumericCellValue();
        int  tenure=(int) r1.getCell(2).getNumericCellValue();
        Thread.sleep(5000);
        String l=Integer.toString(loan);
        String rate=Integer.toString(rateOfInterest);
        String t=Integer.toString(tenure);
        amount.sendKeys(l);
        WebElement per=driver.findElement(By.xpath("//*[@id='RATE_OF_INTEREST']"));
        per.clear();
        per.sendKeys(rate);
        WebElement period=driver.findElement(By.xpath("//*[@id='LOAN_TENURE']"));
        period.clear();
        period.sendKeys(t);
        workbook.close();
        WebElement v=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p"));
        String s1=v.getText();
        if(s1.equals("Your Amortization Details (Yearly/Monthly)")){
            System.out.println("Keyword is present");
        }
        else{
            System.out.println("Keyword is not present");
        }
    }
    @AfterMethod
    public void closeMethod()
    {
        report.flush();
        driver.quit();
    }
}
