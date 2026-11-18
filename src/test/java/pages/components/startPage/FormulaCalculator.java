package pages.components.startPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FormulaCalculator {

    public final SelenideElement formulaCalculatorModal = $("section[aria-label='История бросков']");
    public final SelenideElement formulaCalculatorModalHeader = formulaCalculatorModal.$("header");
    public final SelenideElement historyClearButton = formulaCalculatorModal.$(
            "button[aria-label='Очистить историю']"
    );
    public final ElementsCollection rollCards = formulaCalculatorModal.$$(".mt-auto > div");
    public final SelenideElement formulaCalculatorInput = formulaCalculatorModal.$(
            "input[aria-label='Формула для броска']"
    );
    public final SelenideElement rollButton = formulaCalculatorModal.$(
            "button[aria-label='Формула для броска']"
    );
    public final SelenideElement formulaCalculatorCloseButton = $(
            "button[aria-label='История бросков'].rounded-full"
    );



    @Step("Formula calculator modal become visible")
    public void formulaCalculatorModalBecomeVisible(){
        formulaCalculatorModal.shouldBe(visible);
    }

    @Step("Formula calculator header become visible")
    public void formulaCalculatorHeaderBecomeVisible(){
        formulaCalculatorModalHeader.shouldBe(visible);
    }

    @Step("Formula calculator history clean button become visible")
    public void historyCleanButtonBecomeVisible(){
        historyClearButton.shouldBe(visible);
    }

    @Step("Formula calculator history panel become visible")
    public void historyPanelBecomeVisible(){
        formulaCalculatorModal.shouldBe(visible);
    }

    @Step("Formula calculator input become visible")
    public void formulaCalculatorInputBecomeVisible(){
        formulaCalculatorInput.shouldBe(visible);
    }

    @Step("Type formula to formula calculator input")
    public void typeFormulaToInput(String formula){
        formulaCalculatorInput.setValue(formula);
    }

    @Step("Formula calculator roll button become visible")
    public void rollButtonBecomeVisible(){
        rollButton.shouldBe(visible);
    }

    @Step("Formula calculator roll button click")
    public String rollButtonClick(){
        rollButton.click();
        rollCards.shouldHave(sizeGreaterThan(0));
        return rollCards.last().$(".break-all").getText();
    }

    // Для проверки распределения выпавших значений
    public enum Dice {
        D4("d4", 4),
        D6("d6", 6),
        D8("d8", 8),
        D10("d10", 10),
        D12("d12", 12),
        D20("d20", 20),
        D100("d100", 100);

        private final String formula;
        private final int sides;

        Dice(String formula, int sides) {
            this.formula = formula;
            this.sides = sides;
        }

        public String getFormula() {
            return formula;
        }

        public int getSides() {
            return sides;
        }

        public String withCount(int count) {
            return count + formula;
        }

        public double getExpectedAverage() {
            return (1 + sides) / 2.0;
        }



        // 2. Минимально приемлемое количество выпадений одной грани (правило 4 сигм)
        public long getMinExpectedCount(int rollsCount) {
            double p = 1.0 / sides;
            double expected = rollsCount * p;
            double tolerance = Math.max(4.0 * Math.sqrt(rollsCount * p * (1.0 - p)), 5.0);
            return Math.max(0, Math.round(expected - tolerance));
        }

        // 3. Максимально приемлемое количество выпадений одной грани (правило 4 сигм)
        public long getMaxExpectedCount(int rollsCount) {
            double p = 1.0 / sides;
            double expected = rollsCount * p;
            double tolerance = Math.max(4.0 * Math.sqrt(rollsCount * p * (1.0 - p)), 5.0);
            return Math.round(expected + tolerance);
        }

        public boolean isDistributionUniform(int[] rolls) {
            if (rolls == null || rolls.length == 0) {
                return false;
            }

            int rollsCount = rolls.length;
            long minExpected = getMinExpectedCount(rollsCount);
            long maxExpected = getMaxExpectedCount(rollsCount);

            // Массив для подсчета частоты выпадения каждой грани (индекс 1..sides)
            int[] frequencies = new int[sides + 1];
            long sum = 0;

            for (int roll : rolls) {
                // Проверка, что выпавшее число не выходит за пределы граней кубика
                if (roll < 1 || roll > sides) {
                    return false;
                }
                frequencies[roll]++;
                sum += roll;
            }

            // 1. Проверяем, что частота каждой грани укладывается в интервал 4 сигм
            for (int face = 1; face <= sides; face++) {
                if (frequencies[face] < minExpected || frequencies[face] > maxExpected) {
                    return false;
                }
            }

            // 2. Проверяем среднее арифметическое (дисперсия равномерного дискретного распределения: (N^2 - 1) / 12)
            double actualAverage = (double) sum / rollsCount;
            double expectedAverage = getExpectedAverage();
            double stdError = Math.sqrt(((sides * sides - 1.0) / 12.0) / rollsCount);
            double avgTolerance = 4.0 * stdError;

            return Math.abs(actualAverage - expectedAverage) <= avgTolerance;
        }

        @Override
        public String toString() {
            return formula;
        }
    }

    @Step("Roll dice and get parsed results")
    public int[] rollAndGetResults(String formula) {
        typeFormulaToInput(formula);
        String detailsText = rollButtonClick();
        String resultsPart = detailsText.replaceFirst(Pattern.quote(formula), "");
        List<Integer> rolls = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\d+").matcher(resultsPart);
        while (matcher.find()) {
            rolls.add(Integer.parseInt(matcher.group()));
        }
        return rolls.stream().mapToInt(Integer::intValue).toArray();
    }

    @Step("Get last roll numeric result")
    public int getLastRollResult() {
        String resultText = rollCards.last().$(".text-2xl").getText().trim();
        return Integer.parseInt(resultText);
    }

    @Step("Formula calculator close")
    public void formulaCalculatorButtonClose(){
        formulaCalculatorCloseButton.shouldBe(visible);
        formulaCalculatorCloseButton.click();
        formulaCalculatorModal.shouldBe(disappear);
    }

}
