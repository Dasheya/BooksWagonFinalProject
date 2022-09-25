package com.bw.qa.testcases;


import util.testutil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import java.io.FileNotFoundException;

public class LoginPageTest extends TestBase{
    testutil testutil;
    String sheetName = "bwlogin";
    Logger log = Logger.getLogger(LoginPageTest.class);
    LoginPage loginpage;
    HomePage homepage;

    // call super class constuctor means TestBase constructor
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        loginpage = new LoginPage();
        homepage=new HomePage();
    }

    @Test(priority = 1)
    public void LoginPageTitleTest()
    {
        String title = loginpage.ValidateLoginPageTittle();
        Assert.assertEquals(title,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }
    @DataProvider
    public Object[][] getLoginTestData() {
        Object data[][] = testutil.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getLoginTestData")
    public void multipleLoginTest(String userName, String password) throws InterruptedException {
        homepage = loginpage.loginMultipleAccounts(userName, password);
        Thread.sleep(3000);
        log.info("login successful with username: " + userName);
    }
    @Test(priority = 2)
    public void BW_logoTest()
    {
        boolean flag = loginpage.ValidateBW_Image();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {

        homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}