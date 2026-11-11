package pages;


import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;



public class TTGClubSpellsScreenPage {

    private final SelenideElement sectionHeader = $(".section-header");

    @Step("Get page section header")
    public SelenideElement getSectionHeaderText() {

        return sectionHeader;
    }

}
