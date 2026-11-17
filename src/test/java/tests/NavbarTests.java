package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.SearchPage;
import pages.components.SearchModal;
import pages.components.navbar.*;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.text;

public class NavbarTests extends TestBase{
    TestDataTTGClub testData = new TestDataTTGClub();

    @Test
    @DisplayName("Checking the navigation menu header display")
    void checkOpenNavigationModalMenuHeader() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.headerBecomeVisible();
        navigationMenu.menuBecomeVisible();
        navigationMenu.footerBecomeVisible();
    }

    @Test
    @DisplayName("Checking the navigation menu close by button")
    void checkCloseNavigationModalMenu() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.closeButtonBecomeVisible();
        navigationMenu.closeNavMenu();
    }

    @Test
    @DisplayName("Checking the display of the bookmarks interface")
    void checkOpenBookmarksList() {
        Bookmarks bookmarks = navbar.bookmarksButtonClick();
        bookmarks.bookmarksHeaderBecomeVisible();
        bookmarks.bookmarksListBecomeVisible();
    }

    @Test
    @DisplayName("Checking the display of the settings modal")
    void checkOpenSettingsModal() {
        SettingsModal settingsModal = navbar.settingsButtonClick();
        settingsModal.settingsModalBecomeVisible();
    }

    @DisplayName("Checking the display of header. ")
    @ParameterizedTest(name = "Header - {0}")
    @MethodSource("tests.testdata.TestDataTTGClub#settingsModalHeaders")
    void checkDisplayOfSettingsHeaders(String headerText) {
        SettingsModal settingsModal = navbar.settingsButtonClick();
        settingsModal.settingsModalHeaderBecomeVisible(headerText);
    }

    @DisplayName("Check the switch theme. ")
    @ParameterizedTest(name = "Theme - {0}")
    @EnumSource(SettingsModal.Theme.class)
    void checkSwitchColorTheme(SettingsModal.Theme theme) {
        SettingsModal settingsModal = navbar.settingsButtonClick();
        settingsModal.selectAndVerifyTheme(theme);
    }

    @Test
    @DisplayName("Checking the display of the search modal interface")
    void checkOpenSearchInputBlock() {
        SearchModal searchModal = navbar.searchButtonClick();
        searchModal.inputBlockBecomeVisible();
        searchModal.resultsBlockBecomeVisible();
        searchModal.searchPageLinkBecomeVisible();
    }

    @Test
    @DisplayName("Checking the transition to the search page")
    void checkGoingToTheSearchPage() {
        SearchModal searchModal = navbar.searchButtonClick();
        SearchPage searchPage = searchModal.redirectToSearchPage();
        searchPage.getPageTitle().shouldHave(text(testData.searchPageTitle));
    }

    @Test
    @DisplayName("Checking the display of the bug report modal interface")
    void checkBugReportModalHeaderDisplay() {
        BugReportModal bugReportModal = navbar.bugReportButtonClick();
        bugReportModal.bugReportModalHeaderBecomeVisible();
        bugReportModal.bugReportModalTitleBecomeVisible();
        bugReportModal.bugReportModalBodyBecomeVisible();
        bugReportModal.bugReportModalTabsBecomeVisible();
        bugReportModal.bugReportModalFooterBecomeVisible();
    }

    @Test
    @DisplayName("Checking the close of the bug report modal")
    void checkBugReportModalClose() {
        BugReportModal bugReportModal = navbar.bugReportButtonClick();
        bugReportModal.bugReportModalCloseButtonBecomeVisible();
        bugReportModal.bugReportModalClose();
    }

    @Test
    @DisplayName("Checking the display of authorization modal and login interface")
    void checkAuthorizationModalDisplay() {
        AuthorizationModal authorizationModal = navbar.authorizationButtonClick();
        authorizationModal.authorizationModalBecomeVisible();
        authorizationModal.loginInputBecomeVisible();
        authorizationModal.passwordInputBecomeVisible();
        authorizationModal.rememberMeBecomeVisible();
        authorizationModal.forgottenPasswordButtonBecomeVisible();
        authorizationModal.signInPasswordButtonBecomeVisible();
    }

    @Test
    @DisplayName("Checking the close button of authorization modal")
    void checkCloseButtonDisplay() {
        AuthorizationModal authorizationModal = navbar.authorizationButtonClick();
        authorizationModal.closeButtonBecomeVisible();
        authorizationModal.closeButtonClick();
    }

    @Test
    @DisplayName("Checking the display of password recovery interface")
    void passwordRecoveryEmailInputDisplay() {
        AuthorizationModal authorizationModal = navbar.authorizationButtonClick();
        authorizationModal.forgottenPasswordButtonClick();
        authorizationModal.passwordRecoveryInputBecomeVisible();
        authorizationModal.sendRecoveryEmailButtonBecomeVisible();
        authorizationModal.backToSignInBecomeVisible();
    }
}


