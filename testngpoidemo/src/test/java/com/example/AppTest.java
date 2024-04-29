package com.example;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.relevantcodes.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void testsetup() {
        ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\subas\\Documents\\SoftwareTestingClassWork\\testngpoi");
        report=new ExtentReports();
        report.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    //@Test(dataProvider = "data")
    //public void shouldAnswerWithTrue(String username,String password) throws Exception {
    @Test
    public void shouldAnswerWithTrue()throws Exception{
        test=report.createTest("Test1","This is the first test");
        test.log(Status.INFO, "Extent report demo");
        FileInputStream fs = new FileInputStream("C:\\orange.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet login = workbook.getSheet("login");
        XSSFRow r1 = login.getRow(1);
        String username = r1.getCell(0).getStringCellValue();
        String password = r1.getCell(1).getStringCellValue();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@name='username']"))
                .sendKeys(username);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
                .sendKeys(password);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);
        System.out.println(username);
        System.out.println(password);
        workbook.close();
    }
    // @DataProvider(name="data")
    // public Object[][] fetchData() throws Exception{
    //      Object[][] data=new Object[2][2];
    //      data[0][0]="Admin";
    //      data[0][1]="admin123";
    //      data[1][0]="Admin111";
    //      data[1][1]="admin1234";
    //      return data;
    // }

    @AfterMethod
    public void closemethod(ITestResult result) throws Exception {
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
