package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import java.io.FileWriter;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;

public class CheckOutPage {
    private final SelenideElement nextButton = $("button[type=submit][class^='button action continue primary']");
    private final SelenideElement shippingMethodRadioButton = $("input[type=radio][name^='ko_unique_1']");
    private final SelenideElement placeOrderButton = $("button[type=submit][class^='action primary checkout']");
    private final SelenideElement orderIdLink = $("a[class^=order-number]");

    public void clickOnTableRateShippingMethod() {
        shippingMethodRadioButton.shouldBe(visible);
        shippingMethodRadioButton.click();
    }

    public void clickOnNextButton() {
        nextButton.shouldBe(visible);
        nextButton.click();
    }

    public void placeOrderButton() {
        placeOrderButton.shouldBe(visible);
        placeOrderButton.click();
    }

    public String getOrderIdNumber() {
        orderIdLink.shouldBe(visible);
        return orderIdLink.getText();
    }

    public void writeOrderIdToFile(String filePath) {
        String orderId = getOrderIdNumber();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(orderId);
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the order ID to the file: " + e.getMessage());
        }
    }
}
