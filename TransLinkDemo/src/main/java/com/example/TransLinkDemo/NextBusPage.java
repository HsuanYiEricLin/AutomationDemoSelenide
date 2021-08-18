package com.example.TransLinkDemo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NextBusPage {
    public SelenideElement iframeNextBus = $x(".//iframe[@title='Next Bus']");
    public SelenideElement eastButton = $x("//a[@href=\"/text/route/099/direction/EAST\"]");
    public SelenideElement addFavButton = $x("//button[@data-type =\"unstyledButton\" and contains(., 'Add Fav')]");
    public SelenideElement addToFavDialog = $x("//dialog[@id=\"add-to-favourites_dialog\"]");
    public SelenideElement addToFavDialogTextArea = $x("//textarea[@name = \"newFavourite\"]");
    public SelenideElement addToFavDialogConfirm = $x("//dialog[@id=\"add-to-favourites_dialog\"]//button[@value =\"confirm\"]");
    public SelenideElement myFavButton = $x("//a[@href=\"/next-bus/favourites\" and contains(.,\"My Favs\") ]");
    public SelenideElement route99CBtoUBC = $x("//div[@class= \"txtRouteTitle\" and text() = \"99 Commercial-Broadway / UBC (B-Line)\"]");
    public SelenideElement routeTitle = $x("//div[@class= \"txtRouteTitle\"]");
    public SelenideElement exchangeBay7 = $x("//a[@href=\"/text/stop/61935/route/099\"]");
    public SelenideElement stopNumber = $x("//div[@class=\"stopNo\"]");
    public SelenideElement stop61935 = $x("//div[@class=\"stopNo\" and text() = \"Stop # 61935\"] ");
}
