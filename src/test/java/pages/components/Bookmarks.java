package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Bookmarks {

    private final SelenideElement bookmarksHeader = $(
            ".px-4.pt-4.pb-2.text-lg.font-semibold.text-highlighted"
    );
    private final SelenideElement bookmarksBody = $(".flex.flex-col.gap-5.px-2.pb-4");


    @Step("Bookmarks header become visible")
    public void bookmarksHeaderBecomeVisible() {
        bookmarksHeader.shouldBe(visible);
    }

    @Step("Bookmarks list become visible")
    public void bookmarksListBecomeVisible() {
        bookmarksBody.shouldBe(visible);
    }
}
