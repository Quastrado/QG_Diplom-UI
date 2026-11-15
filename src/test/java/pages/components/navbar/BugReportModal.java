package pages.components.navbar;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BugReportModal {

    private final SelenideElement bugReportModalHeader =  $(
            "div[data-slot='content'] div[data-slot='header']"
    );
    private final SelenideElement bugReportModalBody = $("div[data-slot='content'] div[data-slot='body']");
    private final SelenideElement bugReportModalFooter = $(
            "div[data-slot='content'] div[data-slot='footer']"
    );
    private final SelenideElement bugReportModalTitle = $("div[data-slot='header'] h2[data-slot='title']");
    private final SelenideElement bugReportModalCloseButton = $("button[data-slot='close']");
    private final SelenideElement bugReportTab = $(byText("Баг-репорт")).closest("button");
    private final SelenideElement wishTab = $(byText("Баг-репорт")).closest("button");

    @Step("Bug report modal header become visible")
    public void bugReportModalHeaderBecomeVisible() {
        bugReportModalHeader.shouldBe(visible);
    }

    @Step("Bug report modal header become visible")
    public void bugReportModalTitleBecomeVisible() {
        bugReportModalTitle.shouldBe(visible);
    }

    @Step("Bug report modal body become visible")
    public void bugReportModalBodyBecomeVisible() {
        bugReportModalBody.shouldBe(visible);
    }

    @Step("Bug report modal tabs become visible")
    public void bugReportModalTabsBecomeVisible() {
        bugReportTab.shouldBe(visible);
        wishTab.shouldBe(visible);
    }

    @Step("Bug report modal footer become visible")
    public void bugReportModalFooterBecomeVisible() {
        bugReportModalFooter.shouldBe(visible);
    }


    @Step("Bug report modal close button become visible")
    public void bugReportModalCloseButtonBecomeVisible() {
        bugReportModalCloseButton.shouldBe(visible);
    }

    @Step("Close bug report modal")
    public void bugReportModalClose() {
        bugReportModalCloseButton.click();
        bugReportModalHeader.shouldBe(disappear);
        bugReportModalBody.shouldBe(disappear);
        bugReportModalFooter.shouldBe(disappear);
    }

}
