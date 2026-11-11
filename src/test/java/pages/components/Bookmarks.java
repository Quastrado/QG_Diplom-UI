package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Bookmarks {

    private final SelenideElement bookmarksBody = $(".nav-bookmarks");

    @Step("Become visible")
    public void becomeVisible() {
        bookmarksBody.shouldBe(visible);
    }
}
