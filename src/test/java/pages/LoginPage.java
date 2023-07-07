package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import utils.DataReader;
import utils.User;

public class LoginPage {
    private final SelenideElement emailInputField = $("#email");
    private final SelenideElement passwordInputField = $("#pass");
    private final SelenideElement signInButton = $("#send2");
    User user = DataReader.getData(User.class);

    public void setUserEmail() {
        String userEmail = user.getUserEmail();
        emailInputField.shouldBe(visible);
        emailInputField.setValue(userEmail);
    }

    public void setUserPassword() {
        String userPassword = user.getUserPassword();
        passwordInputField.shouldBe(visible);
        passwordInputField.setValue(userPassword);
    }

    public void clickOnSignInButton() {
        signInButton.shouldBe(visible);
        signInButton.click();
    }
}
