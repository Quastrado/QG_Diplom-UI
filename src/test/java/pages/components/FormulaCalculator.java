package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FormulaCalculator {

    private final SelenideElement calculatorInput = $(".n-input__input-el");
    private final SelenideElement calculateResult = $("._dice-history-item__result_f039v_10");

    @Step("Calculate formula")
    public void calculateFormula(String formula){
        calculatorInput.type(formula);
        calculatorInput.pressEnter();
    }

    @Step("Get calculate result")
    public SelenideElement getCalculateResult(){
        return calculateResult;
    }

}
