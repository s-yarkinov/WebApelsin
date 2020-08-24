package cardOrder;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.loginPage;
import pageObjects.cardOrderPage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;


public class OrderCard {

    {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    loginPage loginPage = new loginPage();
    cardOrderPage cardOrderPage = new cardOrderPage();

    @Before
    public void logIn() {
        loginPage.openPage();
        loginPage.setLogin("991013968");
        loginPage.setPassField("higafe64");
        loginPage.signUp();
        cancelingDraftOrder();
    }

    public void cancelingDraftOrder() {
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[2]/header/div/button/span/i")).click();
        $("a[href=\"/ru/proposal\"]").click();

        String lastOrderStatus = $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/table/tr[1]/td[4]/div")).getAttribute("class");

        if (lastOrderStatus.equals("CANCELLED")) {
            System.out.println("lastOrderStatus is " + lastOrderStatus);
        } else {
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/table/tr[1]/td[5]/div")).click();
            $(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]")).click();
            System.out.println("Draft order was deleted");
        }
    }

    public void checkNewOrder() {
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[2]/header/div/button/span/i")).click();
        $("a[href=\"/ru/proposal\"]").click();
        String shouldBeClass = "NEW";
        String realClass = $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/table/tr[1]/td[4]/div")).getAttribute("class");
        assertEquals(shouldBeClass, realClass);
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/table/tr[1]/td[5]/div")).click();
        $(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/button[2]")).click();

        /*todo пока так, конда добавять номер заявки, надо проверять по номеру заявки*/
    }


    @Test
    public void orderHumoForCashBiometricId() {
        String uploadFile = "C:\\Users\\Yarkinov\\Pictures\\123.jpg";
        cardOrderPage.openPage();
        cardOrderPage.selectPhysicalCard();
        cardOrderPage.selectHumo("cash");
        cardOrderPage.setBiometricId(uploadFile);
        cardOrderPage.setDeliveryMethod("courier");
        cardOrderPage.setHomeAddress();
        cardOrderPage.setSMSInfoNumber("998991013968");
        cardOrderPage.setPinCode("1234");
        cardOrderPage.clickFinifhButton();
        checkNewOrder();
    }

    @Test
    public void orderHumoForCashForeignId() {
        String uploadFile = "C:\\Users\\Yarkinov\\Pictures\\123.jpg";
        cardOrderPage.openPage();
        cardOrderPage.selectPhysicalCard();
        cardOrderPage.selectHumo("cash");
        cardOrderPage.setForeignId(uploadFile);
        cardOrderPage.setDeliveryMethod("courier");
        cardOrderPage.setHomeAddress();
        cardOrderPage.setSMSInfoNumber("998991013968");
        cardOrderPage.setPinCode("1234");
        cardOrderPage.clickFinifhButton();
        checkNewOrder();
    }

    @Test
    public void orderHumoForCashMilitaryId() {
        String uploadFile = "C:\\Users\\Yarkinov\\Pictures\\123.jpg";
        cardOrderPage.openPage();
        cardOrderPage.selectPhysicalCard();
        cardOrderPage.selectHumo("cash");
        cardOrderPage.setMilitaryId(uploadFile);
        cardOrderPage.setDeliveryMethod("courier");
        cardOrderPage.setHomeAddress();
        cardOrderPage.setSMSInfoNumber("998991013968");
        cardOrderPage.setPinCode("1234");
        cardOrderPage.clickFinifhButton();
        checkNewOrder();
    }

    @Test
    public void orderHumoForCashBiometricIdFromBank() {
        String uploadFile = "C:\\Users\\Yarkinov\\Pictures\\123.jpg";
        cardOrderPage.openPage();
        cardOrderPage.selectPhysicalCard();
        cardOrderPage.selectHumo("cash");
        cardOrderPage.setMilitaryId(uploadFile);
        cardOrderPage.setDeliveryMethod("fromBank");
        cardOrderPage.setSMSInfoNumber("998991013968");
        cardOrderPage.setPinCode("1234");
        cardOrderPage.clickFinifhButton();
        checkNewOrder();
    }

    @Test
    public void orderHumoForCashForeignIdFromBank() {
        String uploadFile = "C:\\Users\\Yarkinov\\Pictures\\123.jpg";
        cardOrderPage.openPage();
        cardOrderPage.selectPhysicalCard();
        cardOrderPage.selectHumo("cash");
        cardOrderPage.setForeignId(uploadFile);
        cardOrderPage.setDeliveryMethod("fromBank");
        cardOrderPage.setSMSInfoNumber("998991013968");
        cardOrderPage.setPinCode("1234");
        cardOrderPage.clickFinifhButton();
        checkNewOrder();
    }


}
