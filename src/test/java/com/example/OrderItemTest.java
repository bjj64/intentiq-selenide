package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import pages.BagsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.CheckOutPage;
import utils.BrowserConfiguration;
import models.FilePathHolder;

public class OrderItemTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private BagsPage bagsPage;
    private CheckOutPage checkOutPage;

    @BeforeEach
    public void setUp() {
        BrowserConfiguration.configure();
        mainPage = new MainPage();
        loginPage = new LoginPage();
        mainPage.open();
        mainPage.clickOnSignInButton();
        loginPage.setUserEmail();
        loginPage.setUserPassword();
        loginPage.clickOnSignInButton();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * This test Opens bags section and chooses bag
     * after that creates order for the delivery for the authoried user
     */

    @Test
    public void testPlaceBagOrder() {
        bagsPage = new BagsPage();
        checkOutPage = new CheckOutPage();
        mainPage.hoverOnGearsButton();
        mainPage.clickOnBagsButton();
        bagsPage.hoverOnBagsItem();
        bagsPage.clickOnAddBagToCardButton();
        bagsPage.checkItemsNumber("1");
        bagsPage.clickOnBasketButton();
        bagsPage.clickOnProceedToCheckoutButton();
        checkOutPage.clickOnTableRateShippingMethod();
        checkOutPage.clickOnNextButton();
        checkOutPage.placeOrderButton();
        checkOutPage.getOrderIdNumber();
        checkOutPage.writeOrderIdToFile(FilePathHolder.OUTPUT_DATA_FILE_PATH);
    }
}
