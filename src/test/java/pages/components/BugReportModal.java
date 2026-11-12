package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BugReportModal {

    private final SelenideElement bugReportModalHeader =  $("[data-slot='header']");
    private final SelenideElement bugReportModalBody = $("[data-slot='body']");
    private final SelenideElement bugReportModalFooter = $("[data-slot='footer']");
    private final SelenideElement bugReportModalTitle = $("[data-slot='title']");
    private final SelenideElement bugReportModalCloseButton = $("[aria-label='Закрыть']");

    @Step("Bug report modal header become visible")
    public void bugReportModalHeaderBecomeVisible() {
        bugReportModalHeader.shouldBe(visible);
    }

    @Step("Bug report modal body become visible")
    public void bugReportModalBodyBecomeVisible() {
        bugReportModalBody.shouldBe(visible);
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
    }

}
