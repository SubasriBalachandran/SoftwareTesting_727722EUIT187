package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
        ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\subas\\Documents\\softwaretesingcw\\extentreportscw2\\src");
        report=new ExtentReports();
        report.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.ixigo.com/");
    }
    @Test
    public void testcaseone() throws InterruptedException, IOException{
        test=report.createTest("Take ScreenShot","Test 1");
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input")).sendKeys("IDP-Independence");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/li")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input")).sendKeys("DEL-New Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[1]/li")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div")).click();
        Thread.sleep(5000);
        //select depature date
        
        while(true){
            WebElement depar=driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]/span[1]"));
            Thread.sleep(2000);
            String de=depar.getText();
            if(de.equals("November 2024"))
            {
            driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[13]")).click();
            Thread.sleep(5000);
            break;
        }
        else{
            driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div/div[2]/button[11]")).click();
        }
        //select return date
        
        while(true){
            WebElement ret=driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[2]/span[3]"));
            Thread.sleep(2000);
            String re=ret.getText();
            if(re.equals("November 2024"))
            {
                driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/div/div[2]/button[13]")).click();
            Thread.sleep(5000);
            break;
        }
        else{
            driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[3]/div/div[1]/div[1]/button[3]")).click();
        }
    }
}
driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[1]/div[2]/div/button[2]")).click();
driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div/button[3]")).click();
driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[1]/div[5]/div/div[3]/p")).click();
driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div[2]/div/div[2]/button")).click();
driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button")).click();
Thread.sleep(5000);
WebElement date=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div/p[2]"));
String check=date.getText();
    if(check.contains("08 Nov")){
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="C:\\Users\\subas\\Documents\\softwaretesingcw\\extentreportscw2\\src\\ss1.png";
        FileUtils.copyFile(screenshot, new File(path));
        test.addScreenCaptureFromPath(path);
        System.out.println("Contains date");
    }
    else{
        System.out.println("Does not contain the date");
    }
}
@Test
public void testcasetwo()throws Exception{
        test=report.createTest("Take ScreenShot 2","Test 2");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,1500)");
        driver.findElement(By.linkText("About Us")).click();
        Thread.sleep(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(5000);
        String s=driver.getCurrentUrl();
        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="C:\\Users\\subas\\Documents\\softwaretesingcw\\extentreportscw2\\src\\ss2.png";
        FileUtils.copyFile(screenshot, new File(path));
        test.addScreenCaptureFromPath(path);
        if(s.contains("about"))
        {
            System.out.println("contains about");
        }
        else{
            System.out.println("Does not contain about");
        }
    }
    @AfterMethod
    public void closeMethod(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(Status.FAIL,"Testcase Failed: "+result.getName());
        }
        else if(result.getStatus()==ITestResult.SUCCESS)
        {
            test.log(Status.PASS,"Testcase Passed: "+result.getName());
        }
        else{
            test.log(Status.SKIP,"skipped"+result.getName());
        }
        report.flush();
        driver.quit();
    }
}
