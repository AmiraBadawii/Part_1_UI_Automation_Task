package base.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Select select;
    protected static Actions action;
    protected static Alert alret;
    protected static JavascriptExecutor jse;

    public PageBase(WebDriver driver)
    {
        PageBase.driver=driver;
        wait = new WebDriverWait(driver,5);
    }
    //method to find element and wait untill the presence of element
    private WebElement safeFind(By locator){return wait.until(ExpectedConditions.presenceOfElementLocated(locator));}

    // method to Click Button
    public void clickButton(By button)
    {
        try{ safeFind(button).click();}
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Method for writing text into TextFiled
    public void sendText(By textBox , String text) { safeFind(textBox).sendKeys(text);}

    //method for returning text of element
    public String getText(By element) { return safeFind(element).getText();}

}
