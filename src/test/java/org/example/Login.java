package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test(priority = 1)
    public void VerifyloginWithvalidcredentials() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam33@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();
    }

    @Test(priority = 2)
    public void VerifyloginWithINvalidcredentials() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam"+generateTimeSteamp()+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);
        driver.quit();
    }
    @Test(priority = 3)
    public void VerifyloginWithINvalidEmaliandValidpassword() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam"+generateTimeSteamp()+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);
        driver.quit();
    }
    @Test(priority = 4)
    public void VerifyloginWithvalidEmaliandInValidpassword() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam33@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);
        driver.quit();
    }
    @Test(priority = 5)
    public void VerifyloginWithoutcredentials() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("");
        driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);
        driver.quit();
    }
    public String generateTimeSteamp(){
        Date date=new Date();
        return date.toString().replace("","_").replace(":","_");
    }

}
