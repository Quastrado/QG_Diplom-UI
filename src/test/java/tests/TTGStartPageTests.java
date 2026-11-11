package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ClassesPage;
import pages.SearchPage;
import pages.TTGClubSpellsScreenPage;
import pages.TokenatorPage;
import pages.components.*;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TTGStartPageTests extends TestBase {
    TestDataTTGClub testData = new TestDataTTGClub();
    Navbar navbar = new Navbar();


    @Test
    @DisplayName("Checking a simple search script from the main page")
    void  displaySearchResult() {
        MainPageSearchModal searchModal = ttgClubStartPage.callSearchModalFromMainPage();
        searchModal.typeSearchQuery(testData.searchQuery);
        TTGClubSpellsScreenPage resultPage = searchModal.redirectToResultPage(
                testData.searchResultLink,
                testData.searchResultPage
        );
        step("The expected title of the resulting page is displayed", () ->
            resultPage.getSectionHeaderText().shouldHave(text(testData.searchQuery))
        );
    }

    @Test
    @DisplayName("Checking the navigation menu header display")
    void checkOpenNavigationModalMenuHeader() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.headerBecomeVisible();
    }

    @Test
    @DisplayName("Checking the navigation menu body display")
    void checkOpenNavigationModalMenuBody() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.menuBecomeVisible();
    }

    @Test
    @DisplayName("Checking the navigation menu footer display")
    void checkOpenNavigationModalMenuFooter() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.footerBecomeVisible();
    }

    @Test
    @DisplayName("Checking the navigation menu close button display")
    void checkNavigationModalMenuCLoseButton() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.menuBecomeVisible();
        navigationMenu.closeButtonBecomeVisible();
    }

    @Test
    @DisplayName("Checking the navigation menu close by button")
    void checkCloseNavigationModalMenu() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.menuBecomeVisible();
        navigationMenu.closeNavMenu();
    }

    @Test
    @DisplayName("Checking the display of the bookmarks header")
    void checkOpenBookmarksList() {
        Bookmarks bookmarks = navbar.bookmarksButtonClick();
        bookmarks.bookmarksHeaderBecomeVisible();
    }

    @Test
    @DisplayName("Checking the display of the bookmarks list")
    void checkOpenBookmarksHeader() {
        Bookmarks bookmarks = navbar.bookmarksButtonClick();
        bookmarks.bookmarksListBecomeVisible();
    }

    @Test
    @DisplayName("Checking the script for navigating to a class page from the main page")
    void checkGoingToTheClassPage() {
        ClassesPage classesPage = ttgClubStartPage.goingToTheClassPage();
        classesPage.classBardLinkCLick().getBardClassArchetypesList().shouldHave(visible);
    }

    @Test
    @DisplayName("Checking the transition to the Tokenator page")
    void checkGoingToTheTokenator() {
        TokenatorPage tokenatorPage = ttgClubStartPage.redirectToTokenator();
        tokenatorPage.getPageTitle().shouldHave(visible);
    }

    @Test
    @DisplayName("Checking the working out of the formula calculator")
    void checkFormulaCalculate() {
        FormulaCalculator formulaCalculator = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculator.calculateFormula(testData.formula);
        formulaCalculator.getCalculateResult().shouldNotBe(empty);
    }

    @Test
    @DisplayName("Checking the opening of a modal window with a video on the main page")
    void openVideoPlayerModal() {
        String videoLinkTitle = ttgClubStartPage.getVideoLinkText();
        VideoMadal videoMadal = ttgClubStartPage.openVideo();
        step("The title text of the video window matches the text of the link element", () ->
            videoMadal.getVideoTitle().shouldHave(text(videoLinkTitle))
        );
    }

    @Test
    @DisplayName("Checking to switch to a dark color theme")
    void checkDarkThemeTurning() {
        ColorThemeModal colorThemeModal = navbar.colorThemeButtonClick();
        colorThemeModal.setDarkColorTheme();
        step("The background color has changed to dark", () -> {
            String backgroundColor = ttgClubStartPage.getBackgroundColor();
            assertEquals(testData.cssExpectedValue, backgroundColor);
        });
    }

    @Test
    @DisplayName("Checking the transition to the search page")
    void checkGoingToTheSearchPage() {
        SearchModal searchModal = navbar.searchButtonClick();
        SearchPage searchPage = searchModal.redirectToSearchPage();
        searchPage.getPageTitle().shouldHave(text(testData.searchPageTitle));
    }

    @Test
    @DisplayName("Checking the display of the bug message window")
    void reportAboutBug() {
        BugReportModal bugReportModal = navbar.bugReportButtonClick();
        bugReportModal.becomeVisible();
    }

}
