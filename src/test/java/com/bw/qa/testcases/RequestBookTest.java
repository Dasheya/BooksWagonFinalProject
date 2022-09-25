package com.bw.qa.testcases;

import base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RequestBook;

import java.io.FileNotFoundException;

public class RequestBookTest extends TestBase {
    LoginPage loginPage;
    RequestBook requestBook;
    Logger log = Logger.getLogger(RequestBookTest.class);

    public RequestBookTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        log.info("*** Starting test cases execution  ****");
        initialization();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        requestBook = new RequestBook();
    }

    @Test(priority = 1)
    public void Request_a_BookTest() throws InterruptedException {
        log.info("user request this book ...");
        requestBook.request(prop.getProperty("isbnElement"), prop.getProperty("bookTitle"),prop.getProperty("bookAuthor"), prop.getProperty("bookEmail"), prop.getProperty("bookPhoneNumber"));
        Thread.sleep(3000);

    }
    @Test(priority = 2)
    public void Verify_ReqestBookPageTest(){

        requestBook.Verify_RequestBookPageText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("browser is closed");

    }

}