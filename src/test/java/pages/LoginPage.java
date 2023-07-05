package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import utils.DataReader;

public class LoginPage {
    private final SelenideElement emailInputField = $("#email");
    private final SelenideElement passwordInputField = $("#pass");
    private final SelenideElement signInButton = $("#send2");

    public void setUserEmail() {
        String email = DataReader.getData( DataReader.class).getUserEmail();
        emailInputField.shouldBe(visible);
        emailInputField.setValue(email);
    }

    public void setUserPassword() {
        String password = DataReader.getData( DataReader.class).getUserPassword();
        passwordInputField.shouldBe(visible);
        passwordInputField.setValue(password);
    }

    public void clickOnSignInButton() {
        signInButton.shouldBe(visible);
        signInButton.click();
    }
}
