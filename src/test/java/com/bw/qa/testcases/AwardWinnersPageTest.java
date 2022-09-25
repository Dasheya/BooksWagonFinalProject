package com.bw.qa.testcases;

import base.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AwardWinnersPage;
import pages.LoginPage;

import java.io.IOException;

public class AwardWinnersPageTest extends TestBase {
    LoginPage loginPage;
    AwardWinnersPage awardWinnersPage;
    Logger log = Logger.getLogger(AwardWinnersPageTest.class);

    public AwardWinnersPageTest () {

        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        log.info("******** Starting test cases execution  *********");
        initialization();
        loginPage = new LoginPage();
        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        awardWinnersPage = new AwardWinnersPage();

    }

    @Test(priority=1)
    public void verifyAwardWinningPageTest() {
        awardWinnersPage.AwardWinnersPageTab();
        log.info("Verify Successfully Search Feature");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        log.info("browser is closed");
    }
}

