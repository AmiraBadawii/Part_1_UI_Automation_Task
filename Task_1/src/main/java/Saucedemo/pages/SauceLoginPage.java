package Saucedemo.pages;

import base.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage extends PageBase {
    public SauceLoginPage(WebDriver driver) {
        super(driver);
    }


    private static By userNameField =By.id("user-name");
    private static By passWordField =By.id("password");
    private static By loginButton   =By.id("login-button");
    //public         By welcomePage   =By.className("header_secondary_container");
    public         By welcomePage   =By.className("title");




    //Method for Login
    public void userLogin(String username,String password)
    {
        sendText(userNameField,username);
        sendText(passWordField,password);
        clickButton(loginButton);
    }

    //Method to assert for logging
    public String getWelcomeMessage(){return getText(welcomePage);}

}
