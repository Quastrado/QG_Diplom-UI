package pages.components.startPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VideoModal {

    private final SelenideElement videoModal = $("div[role='dialog'][data-state='open']");
    private final SelenideElement videoTitle = $("[data-slot='title']");
    private final SelenideElement videoCloseButton = $("button[data-slot='close']");

    @Step("Video modal become visible")
    public void videoModalBecomeVisible(){
        videoModal.shouldBe(visible);
    }

    @Step("Video modal title become visible")
    public void videoTitleBecomeVisible(){
        videoTitle.shouldBe(visible);
    }

    @Step("Video modal close button become visible")
    public void videoCloseButtonBecomeVisible(){
        videoCloseButton.shouldBe(visible);
    }

    @Step("Video modal close button click")
    public void videoCloseButtonClick(){
        videoCloseButtonBecomeVisible();
        videoModal.shouldBe(disappear);
    }
}
