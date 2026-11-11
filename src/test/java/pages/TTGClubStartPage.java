package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.FormulaCalculator;
import pages.components.MainPageSearchModal;
import pages.components.VideoMadal;

import static com.codeborne.selenide.Selenide.$;


public class TTGClubStartPage {

    private final SelenideElement background = $("#body");
    private final SelenideElement pageSearchRow = $(".search_row_g");
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    private final SelenideElement formulaCalculatorButton = $(".n-float-button");
    private final SelenideElement videoLink = $("._link_1lg7o_18");


    @Step("Call search modal from the main page")
    public MainPageSearchModal callSearchModalFromMainPage() {
        pageSearchRow.click();

        return new MainPageSearchModal();
    }

    @Step("Go to the class page from the main page")
    public ClassesPage goingToTheClassPage() {
        classesCard.click();

        return new ClassesPage();
    }

    @Step("Go to the tokenizer page from the main page")
    public TokenatorPage redirectToTokenator() {
        tokenatorChapter.click();

        return new TokenatorPage();
    }

    @Step("Get text of video link")
    public String getVideoLinkText() {
        return videoLink.text();
    }

    @Step("Open video")
    public VideoMadal openVideo() {
        videoLink.click();

        return new VideoMadal();
    }

    @Step("Get background")
    public String getBackgroundColor() {

        return background.getCssValue("background-color");
    }

    @Step("Calculate the formula")
    public FormulaCalculator formulaCalculatorButtonClick() {
        formulaCalculatorButton.click();

        return new FormulaCalculator();
    }


}
