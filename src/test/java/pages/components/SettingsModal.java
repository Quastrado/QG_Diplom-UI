package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SettingsModal {

    private final SelenideElement settingsModal = $("[data-slot='content']");
    private final ElementsCollection settingsModalHeaders = $$(".text-sm font-semibold text-highlighted");


    @Step("Settings modal become visible")
    public void settingsModalBecomeVisible() {
        settingsModal.shouldBe(visible);
    }

    @Step("Settings modal headers become visible")
    public void settingsModalHeaderBecomeVisible(String headerText) {
        settingsModalHeaders.find(text(headerText));
    }

    public enum Theme {
        LIGHT("light", $("[data-slot='content'] p[for$=':light']")),
        DARK("dark", $("[data-slot='content'] p[for$=':dark']")),
        SVIFTY7("svifty7", $("[data-slot='content'] p[for$=':svifty7']"));

        private final String expectedClass;
        private final SelenideElement button;

        Theme(String expectedClass, SelenideElement button) {
            this.expectedClass = expectedClass;
            this.button = button;
        }

        public SelenideElement getButton() {
            return button;
        }

        public String getExpectedClass() {
            return expectedClass;
        }
    }

    @Step("Select {theme} theme and verify html class")
    public SettingsModal selectAndVerifyTheme(Theme theme) {
        theme.getButton().click();
        $("html").shouldHave(cssClass(theme.getExpectedClass()));
        return this;
    }

    @Step("Light theme button click")
    public String lightThemeButtonClick() {
        settingsModalLightThemeButton.click();
        String backgroundColor = $("html").getAttribute("class");
        return backgroundColor;
    }

    @Step("Dark theme button click")
    public String darkThemeButtonClick() {
        settingsModalDarkThemeButton.click();
        String backgroundColor = $("html").getAttribute("class");
        return backgroundColor;
    }

}
