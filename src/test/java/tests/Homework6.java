package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Homework6Page;
import utilities.Driver;
import utilities.ReUsableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Homework6 extends TestBase {
    /*
    Soru 1:
    Kullanıcı https://demo.guru99.com/test/drag_drop.html  sayfasına gider
    Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
    Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak
    yerleştirir.
    Kullanıcı 5000 objesini Debit Side Sağ Account kutusuna taşıyarak
    yerleştirir.
    Kullanıcı 5000 objesini Credit Side Sağ Account kutusuna taşıyarak
    yerleştirir.
    Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide
    edilir.
    Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard
    Assert ile teyit edilir.
    Soru 2:
    https://the-internet.herokuapp.com/tables  sayfasına gidiniz
    1.Tablonun 4 üncü sütunudaki tüm değerleri bir listeye alınız. (Başına $ işareti
    olmadan double değer  olarak.)
    Değerler içinden 50.00’den fazla olanları ayrı bir listeye ekleyiniz.
    Bu liste içinde 100.00 değeri olup olmadığını doğrulayınız. (Assertion)
     */

    Homework6Page homework6Page = new Homework6Page();
    ReUsableMethods reUsableMethods = new ReUsableMethods();

    @Test
    public void test1() throws InterruptedException {

        //Kullanıcı https://demo.guru99.com/test/drag_drop.html  sayfasına gider
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        Driver.getDriver().switchTo().frame("gdpr-consent-notice");
        homework6Page.cookiesAcceptAll.click();
        Driver.wait(2);
        //homework6Page.consent.click();

        //Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(homework6Page.sourceBank, homework6Page.targetDebitSideAccount).perform();
        Driver.wait(2);

        //Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(homework6Page.sourceSales, homework6Page.targetCreditSideAccount).perform();
        Driver.wait(2);

        //Kullanıcı 5000 objesini Debit Side Sağ Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(homework6Page.source5000_1, homework6Page.targetDebitSideAmmount).perform();
        Driver.wait(2);

        //Kullanıcı 5000 objesini Credit Side Sağ Account kutusuna taşıyarak yerleştirir.
        actions.dragAndDrop(homework6Page.source5000_2, homework6Page.targetCreditSideAmmount).perform();
        Driver.wait(2);

        //Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide edilir.
        String expectedAmount = "5000";
        String actualAmount = homework6Page.targetDebitSideAmmount.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAmount, expectedAmount);

        //Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard Assert ile teyit edilir.
        String expectedText = "Perfect!";
        String actualText = homework6Page.perfect.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void test2(){

        //https://the-internet.herokuapp.com/tables  sayfasına gidiniz
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        //1.Tablonun 4 üncü sütunudaki tüm değerleri bir listeye alınız (Başına $ işareti olmadan double değer olarak)

        String dataDue1 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(1,4))).getText();
        double doubleDataDue1 = Double.parseDouble(dataDue1.replace('$',' '));
        System.out.println("doubleDataDue1 = " + doubleDataDue1);

        String dataDue2 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(2,4))).getText();
        double doubleDataDue2 = Double.parseDouble(dataDue2.replace('$',' '));
        System.out.println("doubleDataDue2 = " + doubleDataDue2);

        String dataDue3 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(3,4))).getText();
        double doubleDataDue3 = Double.parseDouble(dataDue3.replace('$',' '));
        System.out.println("doubleDataDue3 = " + doubleDataDue3);

        String dataDue4 = Driver.getDriver().findElement(By.xpath(reUsableMethods.findLocationOfElementInSpecificTableCell(4,4))).getText();
        double doubleDataDue4 = Double.parseDouble(dataDue4.replace('$',' '));
        System.out.println("doubleDataDue4 = " + doubleDataDue4);

        List<Double> table1Sutun4 = new ArrayList<>();
        table1Sutun4.add(doubleDataDue1);
        table1Sutun4.add(doubleDataDue2);
        table1Sutun4.add(doubleDataDue3);
        table1Sutun4.add(doubleDataDue4);

        System.out.println(table1Sutun4);

        //Değerler içinden 50.00’den fazla olanları ayrı bir listeye ekleyiniz.

        List<Double> newListTable1Sutun4 = new ArrayList<>();

        for (int i = 0; i < table1Sutun4.size(); i++){
            if(table1Sutun4.get(i)>50.0){
                newListTable1Sutun4.add(table1Sutun4.get(i));
            }
        }
        System.out.println(newListTable1Sutun4);

        //Bu liste içinde 100.00 değeri olup olmadığını doğrulayınız. (Assertion)

        Assert.assertTrue(newListTable1Sutun4.contains(100.0));

    }
}
