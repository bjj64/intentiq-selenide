package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import utils.DataReader;
import pages.BagsPage;
import pages.LoginPage;
import pages.MainPage;
import pages.CheckOutPage;
import utils.BrowserConfiguration;



public class OrderItemTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private BagsPage bagsPage;
    private CheckOutPage checkOutPage;

    String firstExpressionString = DataReader.getUserEmail();
    String secondExpressionString = DataReader.getUserPassword();


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
        checkOutPage.writeOrderIdToFile("./src/data/test_data.txt");
    }
}