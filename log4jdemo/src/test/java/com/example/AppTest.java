package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
        ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\subas\\Documents\\log4jdemo\\src");
        report=new ExtentReports();
        
    }
    @Test
    public void shouldAnswerWithTrue()
    {
        driver.get("https://www.google.com");
    }
    @AfterMethod
    public void closeMethod(){
        driver.quit();
    }
}
