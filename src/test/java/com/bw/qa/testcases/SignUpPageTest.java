package com.bw.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

import java.io.FileNotFoundException;

public class SignUpPageTest extends TestBase {
        SignUpPage signUpPage;
        LoginPage loginPage;
        LoginPage homePage;

        public SignUpPageTest()  {

            super();
        }
        @BeforeMethod
        public void setUp() throws FileNotFoundException {
            initialization();
            signUpPage = new SignUpPage();
            loginPage = new LoginPage();
            homePage= new LoginPage();
        }
        @Test(priority = 1)
        public void signUpPageTitleTest() {
            String title = signUpPage.ValidateSignUpPageTittle();
            Assert.assertEquals(title, "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
        }
        @Test(priority = 2)
        public void signUpPageElementTest(){
           // signUpPage.signUp( signUpPage.signUp(prop.getProperty("FirstName"), prop.getProperty("MobileNumber"));
            signUpPage.signUp(prop.getProperty("FirstName"),prop.getProperty("MobileNumber"));
        }
        @AfterMethod
        public void tearDown()
    {

        driver.quit();
    }
}
