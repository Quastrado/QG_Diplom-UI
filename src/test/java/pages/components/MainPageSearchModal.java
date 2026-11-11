package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.TTGClubSpellsScreenPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSearchModal {

    private final SelenideElement searchInput = $(".n-input__input-el");
    private final SelenideElement searchModalResults = $(".search-modal__results");
    private final String resultLinkOpen = "a[href=\"";
    private final String resultLinkClose = "\"]";

    @Step("Execute a search query")
    public MainPageSearchModal typeSearchQuery(String searchQuery) {
        searchInput.setValue(searchQuery);

        return this;
    }

    @Step("Choose from the serch results")
    public TTGClubSpellsScreenPage redirectToResultPage(
            String searchResultLink,
            Map<String, TTGClubSpellsScreenPage> searchResultPage
    ) {
        searchModalResults.find(resultLinkOpen + searchResultLink  + resultLinkClose).click();

        return searchResultPage.get(searchResultLink);
    }

}
