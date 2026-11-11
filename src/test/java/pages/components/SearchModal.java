package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchModal {

    private final SelenideElement searchInputBlock = $(
            ".relative.inline-flex.items-center.w-full.p-2.pe-12"
    );
    private final SelenideElement searchResultsBlock = $(".p-1.isolate");
    private final SelenideElement searchPageLink = $("#reka-listbox-item-v-0-0-10");

    @Step("Search input block become visible")
    public void inputBlockBecomeVisible() {
        searchInputBlock.shouldBe(visible);
    }

    @Step("Search results block become visible")
    public void resultsBlockBecomeVisible() {
        searchResultsBlock.shouldBe(visible);
    }

    @Step("Search page link become visible")
    public void searchPageLinkBecomeVisible() {
        searchPageLink.shouldBe(visible);
    }

    @Step("Redirect to search page")
    public SearchPage redirectToSearchPage() {
        searchPageLink.click();
        return new SearchPage();
    }
}
