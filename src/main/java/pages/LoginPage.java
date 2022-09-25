package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends TestBase
{
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement email;

    @FindBy(id = "ctl00_phBody_SignIn_txtPassword")
    WebElement password;

    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement login_button;

    @FindBy(id = "ctl00_imglogo")
    WebElement bw_logo;

    //initialize page factory or page object
    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    // Actions (features)
    public String ValidateLoginPageTittle()
    {
        return driver.getTitle();
    }


    public boolean ValidateBW_Image()
    {
        return bw_logo.isDisplayed();
    }

    public HomePage login(String eml , String pswd) {
        email.sendKeys(eml);
        password.sendKeys(pswd);
        login_button.click();

        return new HomePage();
    }
    public HomePage loginMultipleAccounts(String un, String pass)  {
        // TODO Auto-generated method stub
        email.sendKeys(un);
        password.sendKeys(pass);
        login_button.submit();
        return new HomePage();

    }
}
