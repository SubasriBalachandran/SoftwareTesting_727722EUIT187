package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
import org.openqa.selenium.support.ui.Select;
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
    static Logger log = Logger.getLogger(AppTest.class);
    @BeforeMethod
    public void setup() throws Exception
    {
        report=new ExtentReports();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.opentable.com/");
        Thread.sleep(5000);
        PropertyConfigurator.configure(("C:\\Users\\subas\\Documents\\demo\\src\\main\\java\\com\\example\\resources\\log4j.properties"));

    }
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {
        test=report.createTest("Take ScreenShot","Test 1");
        FileInputStream file=new FileInputStream("C:\\Users\\subas\\Downloads\\opentable.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sh = workbook.getSheet("Sheet1");
        XSSFRow r1 = sh.getRow(1);
        String searchkey = r1.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='home-page-autocomplete-input']")).sendKeys(searchkey);
        driver.findElement(By.xpath("//*[@id='mainContent']/header/div/span/div/div/div[2]/div[2]/button")).click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,1500)");
        driver.findElement(By.xpath("//*[@id='mainContent']/div/section/div[6]/div/label[4]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div/div[2]/div/div[1]/a/h6")).click();
        Thread.sleep(5000);
        
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Switched to new Tab");

        File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="C:\\Users\\subas\\Documents\\demo\\src\\ss.png";
        FileUtils.copyFile(screenshot, new File(path));
        test.addScreenCaptureFromPath(path);
        WebElement e = driver.findElement(By.xpath("//*[@id='restProfileMainContentDtpPartySizePicker']"));
        Select dropdown = new Select(e);
        dropdown.selectByVisibleText("4 people");
        Thread.sleep(2000);
        log.info("Selected People Count has displayed");
        driver.findElement(By.xpath("//*[@id='restProfileMainContentDtpDayPicker-label']")).click();
        driver.findElement(By.xpath(
                "//*[@id=\"restProfileMainContentDtpDayPicker-wrapper\"]/div/div/div/table/tbody/tr[5]/td[3]/button"))
                .click();
        Thread.sleep(2000);

        WebElement e1 = driver.findElement(By.xpath("//*[@id=\"restProfileMainContenttimePickerDtpPicker\"]"));
        Select dropdown1 = new Select(e1);
        dropdown1.selectByVisibleText("6:30 PM");
        log.info("Time has Selected");
        Thread.sleep(3000);
        driver.findElement(
                By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[1]/section[2]/div[5]/article[1]/div/div[5]/button"))
                .click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='baseApp']/div/header/div[2]/div[2]/div[1]/button")).click();
        Thread.sleep(2000);
        log.info("Clicked Sign in");


        // Set<String> windowHandles = driver.getWindowHandles();
        // for (String handle : windowHandles) {
        //     if (!handle.equals(driver.getWindowHandle())) {
        //         System.out.println("Switched");
        //         driver.switchTo().window(handle);
        //     }
        // }

        // Thread.sleep(5000);
       // js.executeScript( "window.scrollBy(0,500)");
        // WebElement element=driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[2]/div/article/h2"));
        // String s=element.getText();
        // if(s.contains("Reservation"))
        // {
        //     System.out.println("true");
        // }
        // else{
        //     System.out.println("false");
        // }
        // driver.findElement(By.xpath("//*[@id='mainContent']/div/div[2]/div[2]/div/article/div/div[1]"));
        // driver.findElement(By.xpath("//*[@id='restProfileSideBarDtpDayPicker']/div/div")).click();
        // while(true){
        //     WebElement depar=driver.findElement(By.xpath("//*[@id=\"react-day-picker-2\"]"));
        //     Thread.sleep(2000);
        //     String de=depar.getText();
        //     if(de.equals("November 2024"))
        //     {
        //         driver.findElement(By.xpath("//*[@id=\"restProfileSideBarDtpDayPicker-wrapper\"]/div/div/div/table/tbody/tr[3]/td[2]/button")).click();
        //         Thread.sleep(5000);
        //         break;
        //     }
        //     else{
        //         driver.findElement(By.xpath("//*[@id=\"restProfileSideBarDtpDayPicker-wrapper\"]/div/div/div/div/div[2]/button[2]")).click();
        //     }
        // }
        // Select drop=new Select(driver.findElement(By.xpath("//*[@id=\"restProfileSideBarDtpPartySizePicker\"]")));
        // drop.selectByVisibleText("4 people");
        // Thread.sleep(5000);
        // Select dropdown=new Select(driver.findElement(By.xpath("//*[@id=\"restProfileSideBartimePickerDtpPicker\"]")));
        // dropdown.selectByVisibleText("6:30 PM");
        // Thread.sleep(5000);
        // driver.findElement(By.xpath("//*[@id='mainContent']/div/div[2]/div[2]/div/article/div/div[5]/button")).click();
        // driver.findElement(By.xpath("//*[@id='baseApp']/div/header/div[2]/div[2]/div[1]/button")).click();
    }
    @AfterMethod 
    public void closeMethod()
    {
        report.flush();
        driver.quit();
    }
}
