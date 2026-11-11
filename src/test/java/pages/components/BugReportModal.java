package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BugReportModal {

    private final SelenideElement bugReportModalHeader =  $(".bug-report-modal__header");
    private final SelenideElement bugReportModalBody = $(".bug-report-modal__body");
    private final SelenideElement bugReportModalFooter = $(".bug-report-modal__footer");

    @Step("Become visible")
    public void becomeVisible() {
        bugReportModalHeader.shouldBe(visible);
        bugReportModalBody.shouldBe(visible);
        bugReportModalFooter.shouldBe(visible);
    }
    
}
