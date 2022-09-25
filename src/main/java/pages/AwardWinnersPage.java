package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AwardWinnersPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"ctl00_liAW\"]/a")
    WebElement awardWinners;

    // initialize Object
    public AwardWinnersPage() {
        PageFactory.initElements(driver, this);
    }

    // Click on award winners tab
    public void AwardWinnersPageTab() {

        awardWinners.click();
    }

}

