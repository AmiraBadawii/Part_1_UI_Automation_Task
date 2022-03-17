package bases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    protected static Properties props;
    protected static WebDriverWait wait;


    //method for chrome Configuration
    @BeforeClass
    public static void setup(){
        props= System.getProperties();
        try
        {
            props.load(new FileInputStream(new File("Resources/GeneralData/Data.properties")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //System.exit(-1);
        }
        System.setProperty(
                "webdriver.chrome.driver",props.getProperty("webdriver.chrome.driver"));
        driver= new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

    @AfterClass
    public void stopDriver()
    {
        driver.quit();
    }
}
