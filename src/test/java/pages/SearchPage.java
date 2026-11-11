package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement pageTitle = $("h1").shouldHave(text("Поиск по сайту"));

    @Step("Get page title text")
    public SelenideElement getPageTitle() {

        return pageTitle;
    }
}
