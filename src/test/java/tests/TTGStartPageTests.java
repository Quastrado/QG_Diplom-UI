package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ClassesPage;

import pages.TTGClubSpellsScreenPage;
import pages.TokenatorPage;
import pages.components.navbar.SettingsModal;
import pages.components.startPage.FormulaCalculator;
import pages.components.startPage.MainPageSearchModal;
import pages.components.startPage.VideoModal;
import tests.testdata.TestDataTTGClub;

import java.awt.*;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    @DisplayName("Checking the formula calculator modal display")
    void checkFormulaCalculatorModalDisplay(){
        FormulaCalculator formulaCalculatorModal = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculatorModal.formulaCalculatorModalBecomeVisible();
        formulaCalculatorModal.formulaCalculatorHeaderBecomeVisible();
        formulaCalculatorModal.historyCleanButtonBecomeVisible();
        formulaCalculatorModal.historyPanelBecomeVisible();
        formulaCalculatorModal.formulaCalculatorInputBecomeVisible();
        formulaCalculatorModal.rollButtonBecomeVisible();
    }

    @Test
    @DisplayName("Checking the formula calculator modal close")
    void checkFormulaCalculatorModalClose(){
        FormulaCalculator formulaCalculatorModal = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculatorModal.formulaCalculatorButtonClose();
    }

    @DisplayName("Checking the formula calculate. ")
    @ParameterizedTest(name = "Formula - {0}")
    @EnumSource(FormulaCalculator.Dice.class)
    void checkDisplayOfSettingsHeaders(FormulaCalculator.Dice dice) {
        FormulaCalculator formulaCalculatorModal = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculatorModal.typeFormulaToInput(dice.getFormula());
        String detailsText = formulaCalculatorModal.rollButtonClick();
        assertTrue(detailsText.contains(dice.getFormula()));
    }

    @DisplayName("Checking uniform distribution of dice rolls.")
    @ParameterizedTest(name = "Dice - {0}")
    @EnumSource(FormulaCalculator.Dice.class)
    void checkDiceUniformDistribution(FormulaCalculator.Dice dice) {
        int rollsCount = 1000;
        String formula = dice.withCount(rollsCount);
        FormulaCalculator formulaCalculatorModal = ttgClubStartPage.formulaCalculatorButtonClick();
        int[] actualRolls = formulaCalculatorModal.rollAndGetResults(formula);
        assertTrue(
                dice.isDistributionUniform(actualRolls),
                String.format(
                        "Распределение для %s (бросков: %d) не является равномерным. Выпавшие значения: %s",
                        dice, rollsCount, Arrays.toString(actualRolls)
                )
        );
    }

    @DisplayName("Check that calculation result does not exceed maximum dice value")
    @ParameterizedTest(name = "Dice - {0}")
    @EnumSource(FormulaCalculator.Dice.class)
    void checkResultNotExceedMaximum(FormulaCalculator.Dice dice){
        FormulaCalculator formulaCalculatorModal = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculatorModal.typeFormulaToInput(dice.getFormula());
        formulaCalculatorModal.rollButtonClick();
        int result = formulaCalculatorModal.getLastRollResult();
        assertTrue(result <= dice.getSides());
    }


}
