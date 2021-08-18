package com.example.TransLinkDemo;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public class TransLinkLandingPage {
    public SelenideElement nextBusButton = $x("//button[@id=\"next-bus\"] ");
    public SelenideElement busRouteSearchInput = $x("//input[@id=\"NextBusSearchTerm\"]");
    public SelenideElement findBusButton = $x("//button[@type=\"submit\" and @form=\"NextBusSearch\"]");
}
