package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.startPage.FormulaCalculator;
import pages.components.startPage.MainPageSearchModal;
import pages.components.startPage.VideoModal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TTGClubStartPage {

    private final SelenideElement background = $("#body");
    private final SelenideElement pageSearchRow = $(".search_row_g");
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    public final SelenideElement formulaCalculatorButton = $(
            "button[aria-label='История бросков'].rounded-full"
    );
    private final SelenideElement videoLink = $("a[href$='/community-news']").closest("section");
    ;


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
    public VideoModal openVideo() {
        videoLink.click();
        return new VideoModal();
    }

    @Step("Get background")
    public String getBackgroundColor() {

        return background.getCssValue("background-color");
    }

    @Step("Calculate the formula")
    public FormulaCalculator formulaCalculatorButtonClick() {
        formulaCalculatorButton.shouldBe(visible);
        formulaCalculatorButton.click();
        return new FormulaCalculator();
    }


}
