package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchBook extends TestBase {

    @FindBy(xpath = "//input[@id='inputbar']")
    WebElement searchBook;

    @FindBy(xpath = "//input[@id='btnTopSearch']")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@value ='Buy Now']")
    WebElement clickOnBookNow;

    @FindBy(xpath = "//*[@id=\"BookCart_lvCart_ctrl0_txtQty\"]")
    WebElement clickOnQuantity;

    @FindBy(xpath = "//*[@id=\"BookCart_lvCart_ctrl0_imgUpdate\"]")
    WebElement QuantityRefreshicon;

    @FindBy(xpath = "//*[@id=\"BookCart_lvCart_imgPayment\"]")
    WebElement PlaceOrderBtn;
    // initialize Object
    public SearchBook() {
        PageFactory.initElements(driver, this);
    }

    // Check search box with book item
    public void SearchBookItem(String strBookName) {
        searchBook.sendKeys(strBookName);
    }

    //This method to check search button
    public void SearchBtn() {

        searchBtn.click();
    }

    // This method is to set search value
    public HomePage clickSearchButton(String strSearchBookName) throws InterruptedException {
        this.SearchBookItem(strSearchBookName);
        Thread.sleep(3000);
        this.SearchBtn();
        Thread.sleep(3000);
        return new HomePage();
    }

    //This method is to click on navigation book
    public void clickOnBookNow() throws InterruptedException {
        clickOnBookNow.click();
        Thread.sleep(3000);
    }

    public void clickOnQuantityInput() throws InterruptedException {

        clickOnQuantity.click();
        Thread.sleep(2000);
    }
    public void clickOnQuantityRefreshicon() throws InterruptedException {
        QuantityRefreshicon.click();
        Thread.sleep(3000);
    }
}