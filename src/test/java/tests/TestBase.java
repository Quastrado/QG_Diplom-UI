package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.TTGClubStartPage;
import helpers.Attach;
import pages.components.navbar.Navbar;


import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    TTGClubStartPage ttgClubStartPage = new TTGClubStartPage();
    Navbar navbar = new Navbar();

    @BeforeAll
    static void setupSelenideEnv(){
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://5e14.ttg.club");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.timeout = 10000; // увеличили таймаут до 10 сек для стабильности в CI

        String remoteUrl = System.getProperty("remoteBrowserUrl");

        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            // Настройки для Selenoid
            Configuration.remote = remoteUrl;
            Configuration.browserVersion = System.getProperty("browserVersion");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } else {
            // Настройки для локального запуска на агенте Jenkins
            Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "true"));

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            Configuration.browserCapabilities = options;
        }
    }

    @BeforeEach
    void beforeEachTest() {
        Selenide.open("");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        String remoteUrl = System.getProperty("remoteBrowserUrl");
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Attach.addVideo();
        };

        closeWebDriver();
    }
}
