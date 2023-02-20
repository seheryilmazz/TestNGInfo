package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Homework5Page {

    public Homework5Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "(//table)[1]//tbody//tr[4]//td[5]")
    public WebElement table1Satir4Sutun5;

    @FindBy (xpath = "(//table)[1]//thead")
    public WebElement table1Head;

    @FindBy (xpath = "(//table)[2]//thead")
    public WebElement table2Head;

    @FindBy (xpath = "(//table)[2]/tbody/tr[3]/td[4]")
    public WebElement table2Satir3Sutun4;

    //@FindBy (xpath = "(//*[text()='$100.00'])[2]")
    //public WebElement table2Satir3Sutun4;

    @FindBy (xpath = "//table[1]/thead/tr/th")
    public List<WebElement> tableList1;

    @FindBy (xpath = "//table[2]/thead/tr/th")
    public List<WebElement> tableList2;
}
