package org.example;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.*;
import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class Login extends MainTest {

    @Test
    void log1() {
        Locator username = page.locator("//*[@id=\"user-name\"]");
        Locator password = page.locator("//*[@id=\"password\"]");
        Locator login = page.locator("//*[@id=\"login-button\"]");
        username.fill("problem_user");
        password.fill("secret_sauce");
        login.click();
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");


}

     @Test void log2 () {
         Locator username = page.locator("//*[@id=\"user-name\"]");
         Locator password = page.locator("//*[@id=\"password\"]");
         Locator login = page.locator("//*[@id=\"login-button\"]");
         username.fill("visual_user");
         password.fill("secret_sauce");
         login.click();
         assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

     }

     @Test void log3 () {
         Locator username = page.locator("//*[@id=\"user-name\"]");
         Locator password = page.locator("//*[@id=\"password\"]");
         Locator login = page.locator("//*[@id=\"login-button\"]");
         username.fill("locked_out_user");
         password.fill("secret_sauce");
         login.click();
         assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

         }

         @Test void log4 () {

             Locator username = page.locator("//*[@id=\"user-name\"]");
             Locator password = page.locator("//*[@id=\"password\"]");
             Locator login = page.locator("//*[@id=\"login-button\"]");
             username.fill("performance_glitch_user");
             password.fill("secret_sauce");
             login.click();
             assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");

             browser.close();
             playwright.close();



         }
}
