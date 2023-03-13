package pagesBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class LoginBase {

    WebDriver driver;
    By myAccountBtn=By.xpath("//span[text()='My Account']");
    By loginText=By.linkText("Login");
    By emailTextBox=By.id("input-email");
    By passwordTextBox=By.id("input-password");
    By lodinBtn=By.xpath("//input[@value='Login']");
    By acwaringMassage=By.xpath("//div[contains(@class,'alert-dismissible')]");
    By VerifyText=By.linkText("Edit your account information");
    public LoginBase(WebDriver driver) {
        this.driver = driver;
    }
    public void clickMyAccountbtn() {
        timeTofindElement(myAccountBtn);
        driver.findElement(myAccountBtn).click();
    }
    public void clickLoginText() {
        timeTofindElement(loginText);
        driver.findElement(loginText).click();
    }
    public void enterEmail(String Text) {
        timeTofindElement(emailTextBox);
        driver.findElement(emailTextBox).sendKeys(Text);
    }
    public void enterEmail2(String Text) {
        timeTofindElement(emailTextBox);
        driver.findElement(emailTextBox).sendKeys(Text);
    }
    public void enterPassword(String Text) {
        timeTofindElement(passwordTextBox);
        driver.findElement(passwordTextBox).sendKeys(Text);
    }
    public void clickLoginBtn() {
        timeTofindElement(lodinBtn);
        driver.findElement(lodinBtn).click();
    }
    public String getwaringMassage() {
        timeTofindElement(acwaringMassage);
        return driver.findElement(acwaringMassage).getText();
    }
    public boolean verifyText() {
        timeTofindElement(VerifyText);
        driver.findElement(VerifyText).isDisplayed();
        return true;
    }

    public void timeTofindElement(By Text) {
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Text));
    }


}
