package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestBook extends TestBase {
    @FindBy(xpath = "//a[text()='Request a Book']")
    WebElement requestBook;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtISBN']")
    WebElement isbnId;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtTitle']")
    WebElement book_title;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtAuthor']")
    WebElement book_author;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtEmailReq']")
    WebElement book_email;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtEmailReq']")
    WebElement book_clickVerifyEmail;

    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_txtEmailReq']")
    WebElement book_phonenum;
    @FindBy(xpath = "//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
    WebElement submit;

    @FindBy(xpath = "//*[@id=\"ctl00_li1\"]/a")
    WebElement RequestBookTab;
    @FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/h4")
    WebElement RequestBookText;


    public RequestBook() {

        PageFactory.initElements(driver, this);
    }
    public Boolean Verify_RequestBookPageText(){
        RequestBookTab.click();
        Boolean h1=RequestBookText.isDisplayed();
        return h1;
    }



    public void request(String isbn, String bt, String ba,String be,String bph) throws InterruptedException {
        requestBook.click();
        isbnId.sendKeys(isbn);
        Thread.sleep(2000);
        book_title.sendKeys(bt);
        book_author.sendKeys(ba);
        book_email.sendKeys(be);
        book_clickVerifyEmail.click();
        book_phonenum.sendKeys(bph);

        submit.click();
        Thread.sleep(2000);

    }
}