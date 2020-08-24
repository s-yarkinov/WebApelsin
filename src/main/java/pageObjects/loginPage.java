package pageObjects;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class loginPage {

    {
        Configuration.baseUrl = "https://naughty-mahavira-6a1872.netlify.app";

    }

    private SelenideElement loginButton = $(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/header/div/div/div/div[5]/a"));
    private SelenideElement phoneField = $(By.xpath("//*[@id=\"phoneNumber1-312_phone_number\"]"));
    private SelenideElement passField = $(By.xpath("//*[@id=\"input-324\"]"));
    private SelenideElement nextButton = $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div/div[2]/div/div/div/div[2]/div/div/form/div/div[4]/button/span"));

    public void openPage() {
        open("/");
        loginButton.click();
    }

    public void setLogin(String phoneNumber){
        phoneField.setValue(phoneNumber);
//        $(By.xpath("//*[@id=\"submit\"]")).click();

    }

    public void setPassField(String password) {
        passField.sendKeys(password);
    }

    public void signUp() {

        nextButton.click();

        for (int i = 1; i <= 5; i++) {
            //div[@class='row clock display-3 justify-center']/div[5]/div[1]/input
            $(By.xpath("//div[@class='row clock display-3 justify-center']/div[" + i + "]/div[1]/input")).sendKeys("7");
        }

//        assertEquals("Предложения и лайфхаки", $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div[4]/div/div[1]/div/div/div[1]/h3")).getText());
    }

}
