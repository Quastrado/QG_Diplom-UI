package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private final SelenideElement navMenuBody = $(".nav-menu");

    @Step("Become visible")
    public void becomeVisible() {
        navMenuBody.shouldBe(visible);
    }
}
