package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationModal {

    public final SelenideElement authorizationModal = $(
            ".grid.md\\:min-h-120.md\\:grid-cols-\\[15rem_1fr\\]"
    );
    public final SelenideElement loginInput = $("[name='usernameOrEmail']");
    public final SelenideElement passwordInput = $("[name='password']");
    public final SelenideElement rememberMeButton = $("[aria-label='Запомнить меня']");
    public final SelenideElement forgottenPasswordButton = $(byText("Забыли пароль?")).closest("button");
    public final SelenideElement signInButton = $(byText("Войти")).closest("button");
    public final SelenideElement closeButton = $("[aria-label='Закрыть']");
    public final SelenideElement passwordRecoveryEmailInput = $("[name='email']");
    public final SelenideElement sendRecoveryEmailButton = $(byText("Отправить ссылку")).closest("button");
    public final SelenideElement backToSignInButton = $(byText("Войти")).closest("button");


    @Step("Authorization modal become visible")
    public void authorizationModalBecomeVisible() {
        authorizationModal.shouldBe(visible);
    }

    @Step("Login input become visible")
    public void loginInputBecomeVisible() {
        loginInput.shouldBe(visible);
    }

    @Step("Password input become visible")
    public void passwordInputBecomeVisible() {
        passwordInput.shouldBe(visible);
    }

    @Step("Remember me button become visible")
    public void rememberMeBecomeVisible() {
        rememberMeButton.shouldBe(visible);
    }

    @Step("Forgotten password button become visible")
    public void forgottenPasswordButtonBecomeVisible() {
        forgottenPasswordButton.shouldBe(visible);
    }

    @Step("Forgotten password button click")
    public void forgottenPasswordButtonClick() {
        forgottenPasswordButton.click();
    }

    @Step("Sign in password button become visible")
    public void signInPasswordButtonBecomeVisible() {
        signInButton.shouldBe(visible);
    }

    @Step("Close button become visible")
    public void closeButtonBecomeVisible() {
        closeButton.shouldBe(visible);
    }

    @Step("Close button click")
    public void closeButtonClick() {
        closeButton.click();
        authorizationModal.shouldBe(disappear);
    }

    @Step("Password recovery email input become visible")
    public void passwordRecoveryInputBecomeVisible() {
        passwordRecoveryEmailInput.shouldBe(visible);
    }

    @Step("Send recovery email button become visible")
    public void sendRecoveryEmailButtonBecomeVisible() {
        sendRecoveryEmailButton.shouldBe(visible);
    }

    @Step("Back to sign in button become visible")
    public void backToSignInBecomeVisible() {
        backToSignInButton.shouldBe(visible);
    }



}
