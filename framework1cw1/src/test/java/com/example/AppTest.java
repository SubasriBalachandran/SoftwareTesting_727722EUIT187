package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @BeforeMethod
    public void setup() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dbankdemo.com/bank/login");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("S@gmail.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("P@ssword12");
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 0)
    public void testcaseone() throws InterruptedException
    {
        String url=driver.getCurrentUrl();
        if(url.contains("home"))
        {
            System.out.println("keyword home is present!");
        }
        else{
            System.out.println("keyword home is not present");
        }
    }
    @Test(priority = 1)
    public void testcasetwo() throws InterruptedException{
        
        driver.findElement(By.linkText("Deposit")).click();
        WebElement deposit=driver.findElement(By.xpath("//*[@id='selectedAccount']"));
        Select dropdown=new Select(deposit);
        dropdown.selectByIndex(2);
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("5000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement amount=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]"));
        if(amount.getText()=="$5000")
        {
            System.out.println("Deposited amount is present");
        }
        else{
            System.out.println("Deposited amount is not present");
        }
    }
    @Test(priority = 2)
    public void testcasethree() throws InterruptedException{
        driver.findElement(By.linkText("Withdraw")).click();
        WebElement deposit=driver.findElement(By.xpath("//*[@id='selectedAccount']"));
        Select dropdown=new Select(deposit);
        dropdown.selectByIndex(2);
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        WebElement amount=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]"));
        if(amount.getText()=="$-3000")
        {
            System.out.println("Withdrawal amount is present");
        }
        else{
            System.out.println("Withdrawal amount is not present");
        }
    }
    @AfterMethod
    public void closemethod(){
        driver.quit();
    }
}
