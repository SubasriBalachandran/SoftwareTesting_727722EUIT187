package com.example;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

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
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://economictimes.indiatimes.com/et-now/results");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement mutualFunds=driver.findElement(By.xpath("/html/body/main/div[4]/nav/div[10]/a"));
        mutualFunds.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/section/main/aside/div[4]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,900)");
        Thread.sleep(5000);
        Select dropdown=new Select(driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[2]/select")));
        dropdown.selectByVisibleText("Canara Robeco");
        Thread.sleep(2000);
        Select scheme=new Select(driver.findElement(By.xpath("/html/body/section/main/aside/div[4]/div[3]/div/select")));
        scheme.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Get Details")).click();

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(handle);
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]")).click();
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[2]/ul/li/ul/li[1]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/span")).click();
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[3]/ul/li/ul/li[3]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/span")).click();
        driver.findElement(By.xpath("/html/body/main/div[10]/section[1]/div/div[2]/div[1]/div[4]/ul/li/ul/li[4]/span")).click();
        driver.findElement(By.xpath("/html/body/main/div[10]/section[3]/div/ul/li[2]")).click();
        driver.findElement(By.xpath("/html/body/main/div[10]/section[5]/div/div[1]/section[1]/div[2]/div[1]/ul/li[1]"));
        WebElement rowelement=driver.findElement(By.xpath("//*[@id='mfReturns']/div[2]/div[2]/ul/li[1]/table/tbody/tr[1]"));
        List<WebElement> li=rowelement.findElements(By.xpath(".//td"));
        for(WebElement r:li)
        {
            System.out.println(r.getText());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
