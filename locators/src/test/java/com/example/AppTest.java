package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     * 
     * @throws InterruptedException
     */
    @Test
    public void shouldAnswerWithTrue() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.demoblaze.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("MacBook air")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(5000);
        WebElement titleEle=driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[2]"));
		WebElement price=driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[3]"));
		String title=titleEle.getText();
		String p=price.getText();
		System.out.println("Name: "+title+" Price: "+p);
        driver.quit();
        // assertTrue( true );
    }
}