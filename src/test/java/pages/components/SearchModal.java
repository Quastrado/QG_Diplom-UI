package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.$;

public class SearchModal {

    private final SelenideElement linkToSearchPage = $(".search-modal__all");

    @Step("Redirect to search page")
    public SearchPage redirectToSearchPage() {
        linkToSearchPage.click();

        return new SearchPage();
    }
}
