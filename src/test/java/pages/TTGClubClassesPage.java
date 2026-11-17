package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TTGClubClassesPage {

    private final SelenideElement pageTitle = $("h1");

    @Step("Page title become visible")
    public void pageTitleBecomeVisible() {
        pageTitle.shouldBe(visible);
    }

    @Step("Verify Classes page '{expectedTitle}' is opened")
    public void verifyPageOpened(String expectedTitle) {
        pageTitleBecomeVisible();
        pageTitle.shouldHave(text(expectedTitle));
    }

}
