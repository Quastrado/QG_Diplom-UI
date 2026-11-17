package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TTGClubTraderPage {

    private final SelenideElement pageTitle = $("h1");
    private final SelenideElement charismaCheckField = $("input[role='spinbutton']");
    private final SelenideElement charismaPlusButton = $("button[aria-label='Увеличить']");
    private final SelenideElement magicAmountDropdownButton = $("button[role='combobox']");
    private final ElementsCollection dropdownOptions = $$("div[role='option']");


    @Step("Page title become visible")
    public void pageTitleBecomeVisible() {
        pageTitle.shouldBe(visible);
    }

    @Step("Charisma check field become visible")
    public void charismaCheckFieldBecomeVisible() {
        charismaCheckField.shouldBe(visible);
    }

    @Step("Charisma plus button become visible")
    public void charismaPlusButtonBecomeVisible() {
        charismaPlusButton.shouldBe(visible);
    }

    @Step("Charisma plus button click")
    public void charismaPlusButtonClick(String charismaBonus) {
        charismaCheckField.shouldBe(visible);
        charismaPlusButtonBecomeVisible();
        charismaPlusButton.click();
        charismaCheckField.shouldHave(value(charismaBonus));
    }

    @Step("Magic amount field become visible")
    public void magicAmountFieldBecomeVisible() {
        magicAmountDropdownButton.shouldBe(visible);
    }

    @Step("Magic amount field become visible")
    public void dropdownOptionsBecomeVisible() {
        dropdownOptions.shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Step("Magic amount field click")
    public void magicAmountFieldClick() {
        magicAmountFieldBecomeVisible();
        magicAmountDropdownButton.click();
        dropdownOptionsBecomeVisible();
    }

    @Step("Choose the amount of magic")
    public void chooseTheAmountOfMagic(String amountOfMagic) {
        dropdownOptions.findBy(exactText(amountOfMagic)).click();
        dropdownOptions.findBy(exactText(amountOfMagic))
                .shouldHave(attribute("aria-selected", "true"));
    }
}