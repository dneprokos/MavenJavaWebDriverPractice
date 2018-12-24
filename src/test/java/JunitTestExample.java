import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class JunitTestExample extends UiTestsBaseClass {

    @Test
    public void UserNavigatesGooglePage_GooglePageShouldBeOpened()
    {
        driver.get(propertyManager.ReturnBaseUrl());

        String expectedPageTitle = "Google";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Test
    public void UserPerformsSearchByInputField_GoogleRedirectsUserToSearchResults()
    {
        //Arrange
        driver.get(propertyManager.ReturnBaseUrl());
        driver.manage().timeouts().implicitlyWait(propertyManager.ReturnImplicitWait(), TimeUnit.SECONDS);
        String searchWord = "webdriver";

        //Action
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.TypeValueToTheSeacrhInputField(searchWord);
        action.sendKeys(Keys.ENTER).build().perform();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //Assert
        String currentUrl = driver.getCurrentUrl();
        String urlStartsWith = "www.google.com.ua/search?";

        Assert.assertTrue(currentUrl.contains(urlStartsWith));
        Assert.assertEquals(searchWord, mainPage.GetSearchResultInputFieldValue());
    }
}
