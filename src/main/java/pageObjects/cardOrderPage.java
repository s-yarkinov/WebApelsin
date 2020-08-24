package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class cardOrderPage {

    private SelenideElement menuLink = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/nav[1]/div[1]/div[6]/a"));
    private SelenideElement physicalTypeCard = $(By.xpath("/html/body/div/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[9]/div/div[1]"));
    //*[@id="app"]/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[9]/div/div[1]
    private SelenideElement virtualTypeCard = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[9]/div/div[2]"));

    private SelenideElement bHumoCard = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[2]"));
    private SelenideElement bUzcardCard = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[2]"));
    private SelenideElement bVisaCard = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[2]"));


    public void openPage() {
        menuLink.click();
    }


    public void selectPhysicalCard() {
        physicalTypeCard.click();
    }

    public void selectVirtalCard() {
        virtualTypeCard.click();
    }

    /**
     * @param typePayment тип оплаты
     *                    для оплаты картой перерайде card
     *                    для оплаты наличными передайте cash
     */
    public void selectHumo(String typePayment) {
        $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[2]")).click();
        //*[@id="app"]/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[2]
        if (typePayment.equals("cash")) {
            $(By.xpath(" /html/body/div/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]")).click();
            //html/body/div/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]
            //*[@id="app"]/div/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]
        } else if (typePayment.equals("card")) {
            $(By.xpath("/html/body/div/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[2]")).click();
        } else {
            System.out.println("wrong parametr");
            System.exit(-1);
        }
    }

    public void selectUzcard(String typePayment) {
        $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[1]/div/div[4]")).click();

        if (typePayment.equals("cash")) {
            $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[3]")).click();

        } else if (typePayment.equals("card")) {
            $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[2]/div/div[2]")).click();
        } else {
            System.err.println("Wrong typePayment parament");
            System.exit(-1);
        }
    }

    private SelenideElement bUploadElement = $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[4]/div/div[3]/div/button"));

    /**
     * @param filePath это тестовый файл, который содержит файл с фото
     */
    //*[@id="app"]/div[1]/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[4]/div/div[3]/div/button
    public void setBiometricId(String filePath) {

        $(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/div/span[4]")).click();

        $(By.xpath("//input[@id='file']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file2']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file3']")).sendKeys(filePath);
        bUploadElement.click();
    }

    /**
     * @param filePath это тестовый файл, который содержит файл с фото
     */
    public void setMilitaryId(String filePath) {
        $(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/div/span[2]")).click();


        $(By.xpath("//input[@id='file']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file2']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file3']")).sendKeys(filePath);
        bUploadElement.click();
    }

    /**
     * @param filePath это тестовый файл, который содержит файл с фото
     */
    public void setForeignId(String filePath) {
        $(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/div/span[3]")).click();

        $(By.xpath("//input[@id='file']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file2']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file3']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file4']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file5']")).sendKeys(filePath);
        $(By.xpath("//input[@id='file6']")).sendKeys(filePath);
        bUploadElement.click();
    }

    /**
     * @param deliveryMethod courier or fromBank
     */
    public void setDeliveryMethod(String deliveryMethod) {
        if (deliveryMethod.equals("courier")) {
            //div[@class = 'v-stepper__wrapper']/div[@class = 'forTo'][2]
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[5]/div/div[3]")).click();
        } else if (deliveryMethod.equals("fromBank")) {
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[5]/div/div[2]")).click();
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[6]/div/div[2]/div/div[1]/div/div/div[1]/div[2]/div/i")).click();
            $(By.xpath("/html/body/div/div[4]/div/div[3]")).click();
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[6]/div/div[2]/div/div[13]")).click();
            $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[6]/div/div[2]/div/button")).click();
        }
    }

    public void setHomeAddress() {
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[7]/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/i")).click();
        $(By.xpath("/html/body/div/div[4]/div/div[2]")).click();
        $(By.xpath("/html/body/div/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[7]/div/div[2]/div/div[4]/div/div/div/input")).setValue("test street");
        $(By.xpath("/html/body/div/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[7]/div/div[2]/div/div[6]/div/div/div/input")).setValue("123");
        $(By.xpath("/html/body/div/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[7]/div/div[2]/div/div[8]/div/div/div/input")).setValue("123");
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[7]/div/div[2]/div/button")).click();
    }

    public void setSMSInfoNumber(String number) {
        $(By.xpath("/html/body/div/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[8]/div/div[2]/div/span[3]/div/div/div/div/input")).setValue(number);
    }

    public void setPinCode(String pinCode) {
        $(By.xpath("/html/body/div/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[8]/div/div[2]/div/span[4]/div/div/div/div/input")).setValue(pinCode);
    }

    public void clickFinifhButton() {
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/main/div/div[3]/div/div[1]/div/div[1]/div[2]/div/div/div[8]/div/div[2]/div/button")).click();
        $(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[1]/div[2]/button")).click();
    }



    public void checkOrderId() {
        // TODO: 13.08.2020  
    }

    public void complateOrder(String phoneNum, String pinCode) {
        // TODO: 13.08.2020  
    }




    /*general file
     * //*[@id="app"]/div[1]/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[4]/div/div[3]/div/div[1]*/

    /*propiska file
     * //*[@id="app"]/div[1]/div[1]/main/div/div[4]/div/div[1]/div/div[1]/div[2]/div/div/div[4]/div/div[3]/div/div[1]*/


    //*[@id="app"]/div[4]/div/div/div[1]/div/span[4] Биометрический хумо
    //*[@id="app"]/div[3]/div/div/div[1]/div/span[4] Uzcard
    //*[@id="app"]/div[3]/div/div/div[1]/div/span[4] Visa

    //*[@id="app"]/div[4]/div/div/div[1]/div/span[3] Иностранный хумо
    //*[@id="app"]/div[3]/div/div/div[1]/div/span[3] uzcard


    //*[@id="app"]/div[4]/div/div/div[1]/div/span[2] военное хумо
    //*[@id="app"]/div[3]/div/div/div[1]/div/span[2] uzcaed


}
