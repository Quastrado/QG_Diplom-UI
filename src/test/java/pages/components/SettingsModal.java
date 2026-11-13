package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SettingsModal {

    private final SelenideElement settingsModal = $("[data-slot='content']");
    private final ElementsCollection settingsModalHeaders = $$(".text-sm font-semibold text-highlighted");
    private final SelenideElement settingsModalLightThemeButton = $$(".rounded-full.cursor-pointer").get(0);
    private final SelenideElement settingsModalDarkThemeButton = $$(".rounded-full.cursor-pointer").get(1);

    @Step("Settings modal become visible")
    public void settingsModalBecomeVisible() {
        settingsModal.shouldBe(visible);
    }

    @Step("Settings modal headers become visible")
    public void settingsModalHeaderBecomeVisible(String headerText) {
        settingsModalHeaders.find(text(headerText));
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
