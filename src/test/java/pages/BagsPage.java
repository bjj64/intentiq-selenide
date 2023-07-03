package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class BagsPage {
    private final SelenideElement bagsItem = $x("//strong/a[contains(.,'Bag')]");
    private final SelenideElement addToCardButton = $("button[type=submit][class^='action tocart primary']");
    private final SelenideElement basketButton = $("a[class^='action showcart']");
    private final SelenideElement basketItemsCounter = $(".counter-number");
    private final SelenideElement proceedToCheckoutButton = $("#top-cart-btn-checkout");


    public void hoverOnBagsItem() {
        bagsItem.hover();
     }

    public void clickOnAddBagToCardButton() {
        addToCardButton.shouldBe(visible);
        addToCardButton.click();
     }

        public void checkItemsNumber(String itemNumber) {
        basketItemsCounter.shouldHave(text(itemNumber));
     }

     public void clickOnBasketButton() {
        basketButton.shouldBe(visible);
        basketButton.click();
     }

      public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.shouldBe(visible);
        proceedToCheckoutButton.click();
     }
}
