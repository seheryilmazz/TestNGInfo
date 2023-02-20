package tests;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homework5Page;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Homework5 {
    /*
    ÖDEV-5 SELENIUM
    Soru 1:
    Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
    Kullanıcı Tablonun 4’üncü satır 5’üncü sütundaki verinin doğruluğunu kontrol
    eder.
    ExpectedValue = http://www.timconway.com
    Soru 2:
    Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
    Birinci tablonun tüm başlıklarının ikinci tablonun tüm başlıkları ile aynı olduğunu
    doğrular.
    (Doğrulamayı manuel olarak tek tek değil toplu veya döngüsel bir doğrulama
    şeklinde yapınız.)
    Soru 3:
    Kullanıcı https://the-internet.herokuapp.com/tables Sayfasına gider
    Kullanıcı 2’inci tabloda 3’üncü satır 4’üncü veriyi XPATH ile locate eder. Değerin
    doğruluğunu kontrol eder.
    ExpectedValue = $100.00
     */

    Homework5Page homework5Page = new Homework5Page();

    @Test
    public void tableTest1(){

        //Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        //Kullanıcı Tablonun 4’üncü satır 5’üncü sütundaki verinin doğruluğunu kontrol eder
        //ExpectedValue = http://www.timconway.com

        String expectedData = "http://www.timconway.com";

        String actualData = homework5Page.table1Satir4Sutun5.getText();
        System.out.println("table4.Satir5.Sutun = " + actualData);

        Assert.assertEquals(expectedData,actualData);
    }
    @Test
    public void tableTest2() {

        //Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        //Birinci tablonun tüm başlıklarının ikinci tablonun tüm başlıkları ile aynı olduğunu doğrular.

        List<String> table1Baslik = new ArrayList<>();
        for (int i = 0; i < homework5Page.tableList1.size(); i++) {
            //String text1 = Driver.getDriver().findElement(By.xpath("(//table)[1]//thead//tr//th[" + i + "]")).getText();
            String text1 = homework5Page.tableList1.get(i).getText();
            System.out.println(text1);
            table1Baslik.add(text1);
        }

        List<String> table2Baslik = new ArrayList<>();
        for (int i = 0; i < homework5Page.tableList2.size(); i++) {
            //String text2 = Driver.getDriver().findElement(By.xpath("(//table)[2]//thead//tr//th[" + i + "]")).getText();
            String text2 = homework5Page.tableList2.get(i).getText();
            System.out.println(text2);
            table2Baslik.add(text2);
        }

        /*for (int i = 0; i < homework5Page.tableList1.size(); i++) {
            Assert.assertEquals(homework5Page.tableList1.get(i).getText(), homework5Page.tableList2.get(i).getText());
        }*/

        //Assert.assertEquals(table1Baslik,table2Baslik);
        Assert.assertTrue(table1Baslik.equals(table2Baslik));
    }
    @Test
    public void tableTest2_1() {

        //Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        String table1Title = homework5Page.table1Head.getText();
        String table2Title = homework5Page.table2Head.getText();

        Assert.assertEquals(table1Title,table2Title);


    }
    @Test
    public void tableTest3(){

        //Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");

        //Kullanıcı 2’inci tabloda 3’üncü satır 4’üncü veriyi XPATH ile locate eder. Değerin doğruluğunu kontrol eder.
        //ExpectedValue = $100.00

        String expectedValue = "$100.00";
        String actualValue = homework5Page.table2Satir3Sutun4.getText();

        Assert.assertEquals(expectedValue,actualValue);

    }



}
