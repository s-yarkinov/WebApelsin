import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testFileUpload {

    {
        Configuration.holdBrowserOpen = true;
    }
    @Test
    public void fileUpload()
    {
        open("file:///C:/Users/Yarkinov/Desktop/testFileUpload.html");
        $(By.xpath("/html/body/form/p/input[1]")).sendKeys("C:\\Users\\Yarkinov\\Pictures\\123.jpg");
    }

}
