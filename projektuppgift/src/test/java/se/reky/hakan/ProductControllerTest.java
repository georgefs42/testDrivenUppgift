package se.reky.hakan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public void setUp() {
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Initialize WebDriverWait with a timeout of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to the test URL
        driver.get("http://localhost:8080/players");
    }

    @Test
    public void testPlayerListCount() {
        // Wait for the player list to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".player")));

        // Verify correct number of players in the list
        int expectedPlayerCount = 2; // Change according to your test scenario
        int actualPlayerCount = driver.findElements(By.cssSelector(".player")).size();
        assertEquals(expectedPlayerCount, actualPlayerCount);
    }

    @Test
    public void testFirstPlayerNameDisplayed() {
        // Wait for the first player's name to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".player:nth-of-type(1) .name")));

        // Verify that the name of the first player is displayed on the page
        WebElement firstPlayerName = driver.findElement(By.cssSelector(".player:nth-of-type(1) .name"));
        assertTrue(firstPlayerName.isDisplayed());
    }

    @Test
    public void testPageTitle() {
        // Wait for the page title to contain the expected title
        wait.until(ExpectedConditions.titleContains("Your Expected Title"));

        // Test that the page title matches the expected value
        String expectedTitle = "Your Expected Title";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testLoginButton() {
        // Wait for the login button to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));

        // Test that the login button has the expected text
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        String expectedButtonText = "Logga in";
        assertEquals(expectedButtonText, loginButton.getText());
    }

    @AfterAll
    public void tearDown() {
        // Close the WebDriver after all tests are finished
        if (driver != null) {
            driver.quit();
        }
    }
}
