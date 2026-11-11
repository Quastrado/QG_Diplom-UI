package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement navbarNavigationButton =  $$(".navbar__btn").get(0);
    private final SelenideElement navbarBookmarksButton = $$(".navbar__btn").get(1);
    private final SelenideElement navbarSearchButton = $$(".navbar__btn").get(2);
    private final SelenideElement navbarBugReportButton = $$(".navbar__btn").get(3);
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
