import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class UiTestsBaseClass
{
    static WebDriver driver;
    static Actions action;
    static PropertyManager propertyManager;

    @BeforeClass
    public static void TestClassSetup()
    {
        driver = new ChromeDriver();
        action = new Actions(driver);
        propertyManager = new PropertyManager().getInstance();
    }

    @AfterClass
    public static void TestClassTearDown()
    {
        driver.quit();
    }

}
