package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class ColorThemeModal {

    private final SelenideElement darkThemeButton = $$(".__button-1vhidqx-lmmd").get(1);

    @Step("Set dark color theme")
    public void setDarkColorTheme() {
        darkThemeButton.click();
    }

}
