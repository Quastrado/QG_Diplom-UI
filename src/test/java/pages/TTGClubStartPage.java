package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.SearchModal;
import pages.components.startPage.FormulaCalculator;
import pages.components.startPage.VideoModal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TTGClubStartPage {

    private final SelenideElement pageSearchRow = $("button[class*='_search_']");
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    public final SelenideElement formulaCalculatorButton = $(
            "button[aria-label='История бросков'].rounded-full"
    );
    private final SelenideElement videoLink = $("a[href$='/community-news']").closest("section");


    @Step("Page search row become visible")
    public void pageSearchRowBecomeVisible(){
        pageSearchRow.shouldBe(visible);
    }


    @Step("Call search modal from the main page")
    public SearchModal callSearchModalFromMainPage() {
        pageSearchRow.click();
        return new SearchModal();
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

   @Step("Open video")
    public VideoModal openVideo() {
        videoLink.click();
        return new VideoModal();
    }

    @Step("Calculate the formula")
    public FormulaCalculator formulaCalculatorButtonClick() {
        formulaCalculatorButton.shouldBe(visible);
        formulaCalculatorButton.click();
        return new FormulaCalculator();
    }


}
