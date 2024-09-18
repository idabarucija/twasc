package org.example;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ErrorUser extends MainTest {
    @BeforeEach
    @DisplayName("BeforeEach")
    void BeforeAll() {
        Locator username = page.locator("//*[@id=\"user-name\"]");
        Locator password = page.locator("//*[@id=\"password\"]");
        Locator login = page.locator("//*[@id=\"login-button\"]");
        username.fill("error_user");
        password.fill("secret_sauce");
        login.click();
    }
    @Test
    void ftest() {
        Locator disfunbutton = page.locator("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
        disfunbutton.click();
        assertThat(disfunbutton).isVisible();
        Locator rezultat = page.locator("//button[contains(@class,'btn btn_secondary')]");
        String expectedText = "Remove";
        disfunbutton.click();
        assertThat(rezultat).hasText(expectedText);
    }
        @Test void stest () {

            Locator dropdown = page.locator("//*[@id=\"header_container\"]/div[2]/div/span/select");
            dropdown.waitFor(new Locator.WaitForOptions().setTimeout(3000));
            dropdown.selectOption("Name (Z to A)");

        }

        @Test void ttest () {

            Locator item = page.locator("//*[@id=\"item_4_title_link\"]/div");
            item.click();
            Locator korpa = page.locator("//*[@id=\"shopping_cart_container\"]/a");
            Locator chckout = page.locator("//*[@id=\"checkout\"]");
            Locator Lastname = page.locator("//*[@id=\"last-name\"]");
            korpa.click();
            chckout.click();
            assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-one.html");
            String inputText = "Barucija";
            Lastname.fill(inputText);
            Assertions.assertEquals(inputText, "Unos u input polje nije uspio");

        }
         @Test void fotest () {


        Locator buttonAddtocart2 = page.locator("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        Locator korpa = page.locator("//*[@id=\"shopping_cart_container\"]/a");
        Locator chckout = page.locator("//*[@id=\"checkout\"]");
        Locator Firstname = page.locator("//*[@id=\"first-name\"]");
        Locator Lastname = page.locator("//*[@id=\"last-name\"]");
        Locator zipCode = page.locator("//*[@id=\"postal-code\"]");
        Locator cont = page.locator("//*[@id=\"continue\"]");
        Locator Paymentinfo = page.locator("//div[@data-test='payment-info-value']");
        Locator finish = page.locator("//*[@id=\"finish\"]");
        buttonAddtocart2.click();
        korpa.click();
        chckout.click();
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-one.html");
        Firstname.fill("Ida");
        Lastname.fill("Barucija");
        zipCode.fill("71000");
        cont.click();
        assertThat(Paymentinfo).hasText("SauceCard #31337");
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-two.html");
        finish.click();
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-complete.html");

}


    @Test void fiftest () {

        Locator link = page.locator("//*[@id=\"item_4_title_link\"]/div");
        Locator text = page.locator("//div[normalize-space(text())='A description should be here, but it failed to render! This error has been reported to Backtrace.']");
        link.click();
        String actualText = text.textContent();
        String expectedText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        if (actualText.trim().equals(expectedText)) {
            System.out.println("Tekst se podudara.");
        } else {
            System.out.println("Tekst se ne podudara.");
        }


    }
        @Test void sixthtest () {

            Locator menu = page.locator("//*[@id=\"react-burger-menu-btn\"]");
            Locator logout = page.locator("//*[@id=\"logout_sidebar_link\"]");
            menu.click();
            logout.click();
            assertThat(page).hasURL("https://www.saucedemo.com/");

        }
            @AfterAll static void teardown () {
                page.close();
                browser.close();
                playwright.close();


            }}











