package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VideoModal {

    private final SelenideElement videoModal = $("div[role='dialog'][data-state='open']");
    ;

    @Step("Video modal become visible")
    public void videoModalBecomeVisible(){
        videoModal.shouldBe(visible);
    }
}
