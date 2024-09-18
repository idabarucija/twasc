package org.example;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
public class MainTest {

    static Playwright playwright;
    static Browser browser;
    static Page page;

    @BeforeEach
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.navigate("http://www.saucedemo.com");
        page.onDialog(dialog -> {
            System.out.println("Prikazan dijalog tipa: " + dialog.type());
            System.out.println("Poruka dijaloga: " + dialog.message());

            // Prihvati alert
            dialog.accept();
        });

        page.navigate("http://www.saucedemo.com");

    }


}