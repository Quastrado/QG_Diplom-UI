package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ClassesPage;

import pages.TTGClubSpellsScreenPage;
import pages.TokenatorPage;
import pages.components.*;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;


public class TTGStartPageTests extends TestBase {
    TestDataTTGClub testData = new TestDataTTGClub();


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
    @DisplayName("Checking the video modal display")
    void openVideoPlayerModal() {
        VideoModal videoModal = ttgClubStartPage.openVideo();
        videoModal.videoModalBecomeVisible();
        videoModal.videoTitleBecomeVisible();
    }

    @Test
    @DisplayName("Checking the close of video modal")
    void closeVideoPlayerModal() {
        VideoModal videoModal = ttgClubStartPage.openVideo();
        videoModal.videoCloseButtonBecomeVisible();
        videoModal.videoCloseButtonClick();
    }


}
