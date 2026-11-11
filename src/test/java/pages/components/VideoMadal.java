package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class VideoMadal {

    private final SelenideElement videoTitle = $(".base-modal__title");

    @Step("Get video title")
    public SelenideElement getVideoTitle(){
        return videoTitle;
    }
}
