package com.bw.qa.testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class HomePageTest extends TestBase {
    LoginPage loginpage;
    HomePage homepage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        loginpage = new LoginPage();
        homepage=new HomePage();
    }

    @Test(priority = 1)
    public void HomePageTitleTest()
    {
        String title = homepage.ValidateHomePageTittle();
        Assert.assertEquals(title,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }
    @Test(priority = 2)
    public String ValidateSearchByTextBook()
    {
        String text = homepage.ValidateSearchByText();
        return text;
    }
    @Test(priority = 3)
    public void ValidateUserNameText()
    {
        homepage.ValidateUserNameText();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}