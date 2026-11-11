package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement pageTitle = $(".page-layout__title");

    @Step("Get page title text")
    public SelenideElement getPageTitle() {

        return pageTitle;
    }
}
