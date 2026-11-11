package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ClassesPage {

    private final SelenideElement classBardLink = $(
            "a[href='/classes/bard'][class='link-item-expand__link']"
    );

    @Step("Click link of bard class")
    public BardClassPage classBardLinkCLick(){
        classBardLink.click();

        return new BardClassPage();
    }
}
