package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Homework6Page {

    public Homework6Page(){

        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@id=\"credit2\"]/a")
    public WebElement sourceBank;

    @FindBy(id = "bank")
    public WebElement targetDebitSideAccount;

    @FindBy(xpath = "//span[text()='Accept All']")
    public WebElement cookiesAcceptAll;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]/p")
    public WebElement consent;

    @FindBy(xpath = "//*[@id=\"credit1\"]/a")
    public WebElement sourceSales;

    @FindBy(id = "loan")
    public WebElement targetCreditSideAccount;

    @FindBy(xpath = "(//*[@id=\"fourth\"]/a)[1]")
    public WebElement source5000_1;

    @FindBy(id = "amt7")
    public WebElement targetDebitSideAmmount;

    @FindBy(xpath = "(//*[@id=\"fourth\"]/a)[2]")
    public WebElement source5000_2;

    @FindBy(id = "amt8")
    public WebElement targetCreditSideAmmount;

    @FindBy(xpath = "(//*[@id=\"equal\"]/a)[1]")
    public WebElement perfect;

    //==========================================

    @FindBy (xpath = "//table[1]//tbody//tr[4]")
    public List<WebElement> tableListSatir4;

}
