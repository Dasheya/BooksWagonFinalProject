package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase
    {
        @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignIn_plnLoginPassword\"]/div[3]/div/a")
        WebElement Signup;

        @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_txtName\"]")
        WebElement firstname;

        @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_txtEmail\"]")
        WebElement mobileNum;

        @FindBy(xpath = "//*[@id=\"ctl00_phBody_SignUp_btnContinue\"]")
        WebElement signUpBtn;

        public SignUpPage(){
            super();
            PageFactory.initElements(driver, this);
        }
        public String ValidateSignUpPageTittle()
        {

            return driver.getTitle();
        }

        public HomePage signUp(String fn,String mn){
            Signup.click();
            firstname.sendKeys(fn);
            mobileNum.sendKeys(mn);
            signUpBtn.click();
            return new HomePage();
        }

    }
