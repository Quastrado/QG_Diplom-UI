package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement navbarNavigationButton =  $("[aria-label='Меню']");
    private final SelenideElement navbarBookmarksButton = $("[aria-label='Закладки']");
    private final SelenideElement navbarSearchButton = $("[aria-label='Поиск']");
    private final SelenideElement navbarBugReportButton = $("[aria-label='Сообщить о баге']");
    private final SelenideElement colorThemeButton = $$(".navbar__btn").get(5);

    @Step("Navigation button click")
    public NavigationMenu navigationMenuButtonClick() {
        navbarNavigationButton.click();

        return new NavigationMenu();
    }

    @Step("Bookmarks button click")
    public Bookmarks bookmarksButtonClick() {
        navbarBookmarksButton.click();

        return new Bookmarks();
    }

    @Step("Bug report button click")
    public BugReportModal bugReportButtonClick() {
        navbarBugReportButton.click();

        return new BugReportModal();
    }

    @Step("Search button click")
    public SearchModal searchButtonClick() {
        navbarSearchButton.click();

        return new SearchModal();
    }

    @Step("Color theme button click")
    public ColorThemeModal colorThemeButtonClick() {
        colorThemeButton.click();

        return new ColorThemeModal();
    }

}
