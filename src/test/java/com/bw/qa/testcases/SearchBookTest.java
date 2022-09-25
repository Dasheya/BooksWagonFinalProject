package com.bw.qa.testcases;
import java.io.IOException;
import base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchBook;


public class SearchBookTest extends TestBase {

    SearchBook searchBook;
    HomePage homePage;
    LoginPage loginPage;
    Logger log = Logger.getLogger(SearchBookTest.class);

    public SearchBookTest () {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        log.info("******** Starting test cases execution  *********");
        initialization();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        searchBook = new SearchBook();
        homePage = new HomePage();
    }

    @Test(priority=1)
    public void verifySearchPageBtnTest() throws Exception{
        searchBook.clickSearchButton("Just do it");
        searchBook.clickOnBookNow();
        log.info("Verify Successfully Search Feature");

    }
//    @Test(priority=2)
//    public void verifyClickOnQuantityInput() throws InterruptedException {
//        searchBook.clickSearchButton("Just do it");
//        searchBook.clickOnBookNow();
//        Thread.sleep(2222);
//        searchBook.clickOnQuantityInput();
//        Thread.sleep(3000);
//    }
//    @Test(priority=3)
//    public void clickOnQuantityRefreshIcon() throws InterruptedException {
//        searchBook.clickSearchButton("Just do it");
//        searchBook.clickOnBookNow();
//        Thread.sleep(2222);
//        searchBook.clickOnQuantityRefreshicon();
//        Thread.sleep(3000);
//    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("browser is closed");
    }
}
