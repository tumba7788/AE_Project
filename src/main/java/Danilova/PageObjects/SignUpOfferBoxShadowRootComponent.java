package Danilova.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpOfferBoxShadowRootComponent {

    WebDriver driver;
    private final WebDriverWait wait;

    By shadowHostSignUpBox = By.cssSelector(".bloomreach-weblayer");
    By closeBox = By.cssSelector(".close-button");

    public SignUpOfferBoxShadowRootComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Does signUp box present?")
    public boolean signUpIsPresent() {
        try {
            final WebElement shadowHost = driver.findElement(shadowHostSignUpBox);
            final SearchContext shadowRoot = shadowHost.getShadowRoot();
            shadowRoot.findElement(shadowHostSignUpBox);
            System.out.println("signUpBox presents");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("signUpBox doesn't present");
            return false;
        }
    }

    @Step("Close signUpBox box")
    public void closeOfferBox() {
        try {
            final WebElement shadowHost = driver.findElement(shadowHostSignUpBox);
            final SearchContext shadowRoot = shadowHost.getShadowRoot();
            shadowRoot.findElement(closeBox).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(shadowHostSignUpBox));
        } catch (NoSuchElementException e) {
            System.out.println("bonus offer doesn't present");
        }
    }
}
