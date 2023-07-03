package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Selenide;
import utils.DataReader;

public class MainPage {

    String testUrl = DataReader.getUrl();

    private final SelenideElement gearsMenuButton = $("#ui-id-6");
    private final SelenideElement bagsButton = $("#ui-id-25");
    private final SelenideElement sigInButton = $(".authorization-link");

    public void open() {
       Selenide.open(testUrl);
    }

    public void hoverOnGearsButton() {
        gearsMenuButton.hover();
     }

    public void clickOnBagsButton() {
        bagsButton.shouldBe(visible);
        bagsButton.shouldHave(text("Bags"));
        bagsButton.click();
     }

     public void clickOnSignInButton() {
        sigInButton.shouldBe(visible);
        sigInButton.shouldHave(text("Sign In"));
        sigInButton.click();
     }
}
