import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;
import sun.security.krb5.Config;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class testTest {
    {
        Configuration.baseUrl = "https://naughty-mahavira-6a1872.netlify.app";
        Configuration.browser = "firefox";
    }
    @Test
    public void test(){
        open("/");
        $(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/header/div/div/div/div[5]/a")).click();
        $(By.xpath("//*[@id=\"phoneNumber1-312_phone_number\"]")).sendKeys("991013968");
        $(By.xpath("//*[@id=\"input-324\"]")).sendKeys("higafe64");
        $(By.xpath("//*[@id=\"app\"]/div/div[1]/main/div/div/div[2]/div/div/div/div[2]/div/div/form/div/div[4]/button")).click();
        //div[@class='row clock display-3 justify-center']//div[1]//div[1]//input[1]
        //div[@class='row clock display-3 justify-center']//div[2]//div[1]//input[1]
        //div[@class='row clock display-3 justify-center']//div[3]//div[1]//input[1]

        for (int i = 1; i <= 5; i++) {
            //div[@class='row clock display-3 justify-center']/div[5]/div[1]/input
            $(By.xpath("//div[@class='row clock display-3 justify-center']/div[" + i + "]/div[1]/input")).sendKeys("7");
        }


    }
}
