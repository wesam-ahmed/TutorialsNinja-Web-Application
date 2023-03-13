package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesBase.LoginBase;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    @AfterMethod public void tearDown(){
        driver.quit();
    }
    @BeforeMethod public void setup(){
        String browserNmae="firefox";
        if (browserNmae.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserNmae.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/");

    }
    @Test(priority = 1)
    public void VerifyloginWithvalidcredentials() {
        LoginBase loginBase=new LoginBase(driver);
        loginBase.clickMyAccountbtn();
        loginBase.clickLoginText();
        loginBase.enterEmail("wesam33@gmail.com");
        loginBase.enterPassword("12345");
        loginBase.clickLoginBtn();
        Assert.assertTrue(loginBase.verifyText());


    }

    @Test(priority = 2)
    public void VerifyloginWithINvalidcredentials() {
        LoginBase loginBase=new LoginBase(driver);
       loginBase.clickMyAccountbtn();
        loginBase.clickLoginText();
        loginBase.enterEmail("wesam"+generateTimeSteamp()+"@gmail.com");
        loginBase.enterPassword("12345678");
        loginBase.clickLoginBtn();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginBase.getwaringMassage(),exwaringMassage);
        /*driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam"+generateTimeSteamp()+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);*/

    }
    @Test(priority = 3)
    public void VerifyloginWithINvalidEmaliandValidpassword() {
        LoginBase loginBase=new LoginBase(driver);
        loginBase.clickMyAccountbtn();
        loginBase.clickLoginText();
        loginBase.enterEmail("wesam"+generateTimeSteamp()+"@gmail.com");
        loginBase.enterPassword("12345");
        loginBase.clickLoginBtn();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginBase.getwaringMassage(),exwaringMassage);

       /* driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam"+generateTimeSteamp()+"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);*/

    }
    @Test(priority = 4)
    public void VerifyloginWithvalidEmaliandInValidpassword() {
        LoginBase loginBase=new LoginBase(driver);
        loginBase.clickMyAccountbtn();
        loginBase.clickLoginText();
        loginBase.enterEmail("wesam33@gmail.com");
        loginBase.enterPassword("12345678");
        loginBase.clickLoginBtn();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginBase.getwaringMassage(),exwaringMassage);
        /*driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("wesam33@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);*/

    }
    @Test(priority = 5)
    public void VerifyloginWithoutcredentials() {
        LoginBase loginBase=new LoginBase(driver);
        loginBase.clickMyAccountbtn();
        loginBase.clickLoginText();
        loginBase.enterEmail("");
        loginBase.enterPassword("");
        loginBase.clickLoginBtn();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(loginBase.getwaringMassage(),exwaringMassage);
        /*driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("");
        driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String acwaringMassage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String exwaringMassage = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(acwaringMassage,exwaringMassage);*/

    }
    public String generateTimeSteamp(){
        Date date=new Date();
        return date.toString().replace("","_").replace(":","_");
    }

}
