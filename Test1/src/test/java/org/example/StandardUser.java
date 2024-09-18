package org.example;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class StandardUser extends MainTest {

    @BeforeEach

    void beforeA () {
        page.navigate("https://www.saucedemo.com/");
        Locator username = page.locator("//input[@data-test='username']");
        Locator password = page.locator("//input[@data-test='password']");
        Locator login = page.locator("//input[@data-test='login-button']");
        username.fill("standard_user");
        password.fill("secret_sauce");
        login.click();

    }

        @Test
        void firstTest () {

            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator buttonAddtocart1 = page.locator("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
            Locator korpa = page.locator("//*[@id=\"shopping_cart_container\"]/a");
            Locator removeButton = page.locator("//*[@id=\"remove-sauce-labs-backpack\"]");
            Locator conToShop = page.locator("//*[@id=\"continue-shopping\"]");
            assertThat(buttonAddtocart1).isVisible();
            buttonAddtocart1.click();
            korpa.click();
            assertThat(page).hasURL("https://www.saucedemo.com/cart.html");
            removeButton.click();
            conToShop.click();
            assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

        }

        @Test
        void secTest () {

            page.waitForLoadState();
            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator buttonAddtocart2 = page.locator("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
            Locator korpa = page.locator("//*[@id=\"shopping_cart_container\"]/a");
            Locator chckout = page.locator("//*[@id=\"checkout\"]");
            Locator Firstname = page.locator("//*[@id=\"first-name\"]");
            Locator Lastname = page.locator("//*[@id=\"last-name\"]");
            Locator zipCode = page.locator("//*[@id=\"postal-code\"]");
            Locator cont = page.locator("//*[@id=\"continue\"]");
            Locator Paymentinfo = page.locator("//div[@data-test='payment-info-value']");
            Locator finish = page.locator("//button[contains(@class,'btn btn_action')]");
            Locator backHome = page.locator("//*[@id=\"back-to-products\"]");
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
            backHome.click();
        }

        @Test
        void thirdtest () {

            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator firstProd = page.locator("//*[@id=\"item_4_title_link\"]/div");
            Locator dropdown = page.locator("//*[@id=\"header_container\"]/div[2]/div/span/select");
            Locator lastprod = page.locator("//*[@id=\"item_3_title_link\"]/div");
            Locator lowestPrice = page.locator("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
            assertThat(firstProd).hasText("Sauce Labs Backpack");
            dropdown.selectOption("Name (Z to A)");
            assertThat(lastprod).hasText("Test.allTheThings() T-Shirt (Red)");
            dropdown.selectOption("Price (low to high)");
            assertThat(lowestPrice).hasText("$7.99");

        }

        @Test
        void fourthtest () {

            page.waitForLoadState();
            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator menu = page.locator("//*[@id=\"react-burger-menu-btn\"]");
            Locator logout = page.locator("//*[@id=\"logout_sidebar_link\"]");
            menu.click();
            logout.click();
            assertThat(page).hasURL("https://www.saucedemo.com/");

        }

    @Test
    void fifthtest () {
        page.waitForLoadState();
        page.navigate("https://www.saucedemo.com/inventory.html");
        Locator title = page.locator("//div[normalize-space(text())='Test.allTheThings() T-Shirt (Red)']");
        Locator image = page.locator("//img[@alt='Test.allTheThings() T-Shirt (Red)']");
        String expectedTitle = title.textContent();
        assertThat(image).hasAttribute("alt", expectedTitle);
    }

        @Test void sixthtest () {

            page.waitForLoadState();
            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator burgerMenu = page.locator("//*[@id=\"react-burger-menu-btn\"]");
            Locator Logout = page.locator("//*[@id=\"logout_sidebar_link\"]");
            burgerMenu.click();
            Logout.click();
            assertThat(page).hasURL("https://www.saucedemo.com/");

        }

        @Test void sevtest () {

            page.waitForLoadState();
            page.navigate("https://www.saucedemo.com/inventory.html");
            Locator menu = page.locator("//*[@id=\"react-burger-menu-btn\"]");
            Locator logout = page.locator("//*[@id=\"logout_sidebar_link\"]");
            menu.click();
            logout.click();
            assertThat(page).hasURL("https://www.saucedemo.com/");

        }
            @AfterEach
            void teardown () {
                  page.close();
                  browser.close();
                  playwright.close();

    }
        }

