import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage
{
    WebDriver driver;

    By searchInputField = By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input");
    By searchInputFieldOnResultsPage = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[1]/input");

    public GoogleMainPage(WebDriver webDriver){
        driver = webDriver;
    }

    public void TypeValueToTheSeacrhInputField(String value){
        driver.findElement(searchInputField).sendKeys(value);
    }

    public String GetSearchResultInputFieldValue(){
        return driver.findElement(searchInputFieldOnResultsPage).getAttribute("value");
    }



}
