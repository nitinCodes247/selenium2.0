package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BrowserUtils {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    JavascriptExecutor js;
    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(ConfigReader.get("timeout"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.action = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public WebElement waitToAppear(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitToAppear(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public boolean waitToDisappear(WebElement element){
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void click(By locator){
        waitToBeClickable(locator).click();
    }
    public void safeClick(By locator){
        try {
            click(locator);
        }catch (Exception e){
            js.executeScript("arguments[0].click();",driver.findElement(locator));
        }
    }
    public void type(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    public String getText(By locator){
        return waitToAppear(locator).getText();
    }
    public void click(WebElement element){
        waitToBeClickable(element).click();
    }
    public void safeClick(WebElement element){
        try {
            click(element);
        }catch (Exception e){
            js.executeScript("arguments[0].click();",element);
        }
    }
    public void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public String getText(WebElement element){
        return waitToAppear(element).getText();
    }

    public void selectByVisibleText(By locator, String text){
        Select select = new Select(waitToAppear(locator));
        select.selectByVisibleText(text);
    }

    public void scrollIntoView(By locator){
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public String getScreenshot(String testCaseName){
        TakesScreenshot snap = (TakesScreenshot) driver;
        File src = snap.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/screenshots/"+testCaseName+".png";
        File dest = new File(path);
        src.renameTo(dest);
        return path;
    }
}
