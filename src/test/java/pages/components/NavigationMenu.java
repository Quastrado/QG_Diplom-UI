package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NavigationMenu {

    private final SelenideElement navMenuHeader = $(".flex.items-center.gap-4.px-6.py-5");
    private final SelenideElement navMenuBody = $("._navigation_1yz1n_1");
    private final SelenideElement navMenuFooter = $("._footer_xtd1t_1");

    @Step("Navigation menu header become visible")
    public void headerBecomeVisible() {
        navMenuHeader.shouldBe(visible);
    }

    @Step("Navigation menu body become visible")
    public void menuBecomeVisible() {
        navMenuBody.shouldBe(visible);
    }

    @Step("Navigation menu footer become visible")
    public void footerBecomeVisible() {
        navMenuFooter.shouldBe(visible);
    }
}
