package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BardClassPage {

    private final SelenideElement bardClassArchetypesList = $(".link-item-expand__arch-list");

    @Step("Get list of bard archetypes")
    public SelenideElement getBardClassArchetypesList(){
        return bardClassArchetypesList;
    }
}
