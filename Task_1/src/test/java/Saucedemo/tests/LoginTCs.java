package Saucedemo.tests;

import Saucedemo.pages.SauceLoginPage;
import bases.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTCs extends TestBase {
    SauceLoginPage LoginPage;

    @DataProvider
    public  static Object[] Data()
    {
        return new Object[][] {
                {"standard_user", "secret_sauce" }, //Happy Scenario with right username and password
                {"standarduser", "secret_sauce" },  //Sad   Scenario with wrong username and right password
                {"standard_user", "secretsauce" } ,  //Sad   Scenario with right username and wrong password
                {"standard_user", "           " } ,  //Sad   Scenario with right username and empty password
                {"             ", "secret_sauce" } ,  //Sad   Scenario with empty username and right password
                {"             ", "            " }   //Sad   Scenario with empty username and empty password

        };
    }

     @Test(dataProvider ="Data")
    //Method for Login
    public void userLogin(String username,String password)
    {
        driver.get(props.getProperty("Saucedemo.url"));
        LoginPage = new SauceLoginPage(driver);
        //LoginPage.userLogin(props.getProperty("User_name"),props.getProperty("Password"));
        LoginPage.userLogin(username,password);
        Assert.assertEquals(LoginPage.getWelcomeMessage(),"PRODUCTS");
    }
}
