package com.example.TransLinkDemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;



public class AddToFavouritesTest {
    private final TransLinkLandingPage transLinkLandingPage = new TransLinkLandingPage();
    private final NextBusPage nextBusPage = new NextBusPage();
    private final String destination = "99 Commercial-Broadway / UBC (B-Line)";
    private final String stopNumber = "Stop # 61935";

    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void searchForBus99() {
        // step 1 Launch any browser and goto https://new.translink.ca/
        open("https://new.translink.ca/");
        // step 2.1 click on next bus tab
        transLinkLandingPage.nextBusButton.click();
        // step 2.2 click to enter
        transLinkLandingPage.busRouteSearchInput.click();
        // step 2.3 enter 99
        transLinkLandingPage.busRouteSearchInput.sendKeys("99");
        // step 2.4 click "find my next bus"
        transLinkLandingPage.findBusButton.click();
    }

    @Test(dependsOnMethods = { "searchForBus99" })
    public void addRouteToFavourites() {
        // step 3 click to add favourite
        nextBusPage.addFavButton.click();
        // step 4 Enter "Translink Auto Homework" in the Edit name
        nextBusPage.addToFavDialogTextArea.click();
        nextBusPage.addToFavDialogTextArea.clear();
        nextBusPage.addToFavDialogTextArea.sendKeys("Translink Auto Homework");
        // step 5 click on "Add to Favourites" button
        nextBusPage.addToFavDialogConfirm.click();
    }

    @Test(dependsOnMethods = { "addRouteToFavourites" })
    public void validateFavouriteRoute() {
        // step 6 Click on "My Favs" icon
        //nextBusPage.myFavButton.click();
        // step 7 Validate "Translink Auto Homework" link is present

        // step 8 Click on "Translink Auto Homework" link
    }

    @Test(dependsOnMethods = { "validateFavouriteRoute" })
    public void navigateToBusStop() {
        // going to iframe = "Next Bus"
        switchTo().frame(nextBusPage.iframeNextBus);
        // step 9 validate "99 Commercial-Broadway / UBC (B-Line)" is displayed
        Assert.assertTrue(nextBusPage.routeTitle.isDisplayed(), destination + " should be displayed");
        Assert.assertEquals(nextBusPage.routeTitle.getText(), destination, "destination should be " + destination);

        // step 10 click “Comm'l-Bdway Stn / Boundary B-Line”
        nextBusPage.eastButton.click();
        // step 11 click on bay 7
        nextBusPage.exchangeBay7.click();
        // added sleep for loading
        sleep(2000);
        // validate "Stop #61935" is displaying
        Assert.assertTrue(nextBusPage.stopNumber.isDisplayed(), stopNumber + " should be displayed");
        Assert.assertEquals(nextBusPage.stopNumber.getText(), stopNumber , "stopNumber should be " + stopNumber);
    }
}
