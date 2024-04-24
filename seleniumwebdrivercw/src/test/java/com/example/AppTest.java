package com.example;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.shoppersstop.com/");
        Thread.sleep(5000);
        driver.close();
        driver =new FirefoxDriver();
        driver.get("https://www.shoppersstop.com/");
        driver.close();
        driver =new InternetExplorerDriver();
        driver.get("https://www.shoppersstop.com/");
        driver.quit();
    }
}
