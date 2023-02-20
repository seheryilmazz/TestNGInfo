package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Iframe extends TestBase {

    @Test
    public void iframeTest(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        Driver.getDriver().switchTo().frame("mce_0_ifr");
        WebElement textDoc = Driver.getDriver().findElement(By.id("tinymce"));
        textDoc.clear();
        textDoc.sendKeys("Iframe test training");

        actions.doubleClick(textDoc).perform();

        WebElement boldButton = Driver.getDriver().findElement(By.xpath(""));

    }
}
