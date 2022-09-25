package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.TestBase.driver;

public class HomePage {
    @FindBy(xpath = "ctl00_phBody_SignIn_txtEmail")
    WebElement searchByText;

    @FindBy(xpath = "//span[@class='usernametext']")
    WebElement userNameText;

    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div[4]/h2")
    WebElement trandingText;


    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }
    public String ValidateHomePageTittle()
    {
        return driver.getTitle();
    }
    public String ValidateSearchByText()
    {
        return searchByText.getTagName();
    }
    public boolean ValidateUserNameText()
    {

        return userNameText.isDisplayed();
    }
    public void ValidateNowTrandingText(){
        trandingText.isDisplayed();
    }

}
