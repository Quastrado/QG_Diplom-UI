package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SearchModal {

    private final SelenideElement searchInputBlock = $(
            ".relative.inline-flex.items-center.w-full.p-2.pe-12"
    );
    private final SelenideElement searchInput = searchInputBlock.$("input");
    private final SelenideElement searchResultsBlock = $(".p-1.isolate");
    private final ElementsCollection searchResults = searchResultsBlock.$$("a[role='option']");
    private final SelenideElement searchPageLink = $("a[href='/search']");

    @Step("Search input block become visible")
    public void inputBlockBecomeVisible() {
        searchInputBlock.shouldBe(visible);
    }

    @Step("Type '{query}' into search page")
    public void inputBlockTypeQuery(String query){
        inputBlockBecomeVisible();
        searchInput.setValue(query);
    }

    @Step("Search results block become visible")
    public void resultsBlockBecomeVisible() {
        searchResultsBlock.shouldBe(visible);
    }

    @Step("Verify search results contain '{expectedText}' with href '{expectedHref}'")
    public void verifyResultPresent(String expectedText, String expectedHref) {
        searchResultsBlock.shouldBe(visible);
        SelenideElement targetResult = searchResults.findBy(text(expectedText));
        targetResult.shouldBe(visible);
        targetResult.$("[data-slot='itemLabelBase']").shouldHave(text(expectedText));
        targetResult.shouldHave(attributeMatching("href", ".*" + expectedHref));
    }

    @Step("Verify no search results found for query")
    public void verifyNoResultsFound(String invalidQuery) {
        inputBlockTypeQuery(invalidQuery);
        resultsBlockBecomeVisible();
        searchResults.shouldHave(size(0));
        searchResultsBlock.shouldHave(text("Боги не нашли ответа на твой запрос"));
    }

    @Step("Click on search result '{expectedText}'")
    public void clickOnResult(String expectedText) {
        resultsBlockBecomeVisible();
        searchResultsBlock.$$("[data-slot='itemLabelBase']")
                .findBy(exactText(expectedText))
                .shouldBe(visible)
                .click();
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
