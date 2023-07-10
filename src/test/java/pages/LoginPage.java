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
        String email = user.getEmail();
        emailInputField.shouldBe(visible);
        emailInputField.setValue(email);
    }

    public void setUserPassword() {
        String password = user.getPassword();
        passwordInputField.shouldBe(visible);
        passwordInputField.setValue(password);
    }

    public void clickOnSignInButton() {
        signInButton.shouldBe(visible);
        signInButton.click();
    }
}
