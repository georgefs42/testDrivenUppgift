package se.reky.hakan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class ProductControllerTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUpBeforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBeforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNumberOfPlayersDisplayed() {
        driver.get("http://localhost:8080/players");
        // Assuming the players are displayed in a list
        int expectedNumberOfPlayers = 2; // Change this to the expected number of players
        // Find all elements with class 'player' assuming it's the class name for player elements
        int actualNumberOfPlayers = driver.findElements(By.className("player")).size();
        assertEquals(expectedNumberOfPlayers, actualNumberOfPlayers,
                "Number of players displayed does not match the expected number");
    }

    @Test
    public void testFirstPlayerNameDisplayed() {
        driver.get("http://localhost:8080/players");
        // Assuming the first player name is displayed in an element with class 'first-player'
        WebElement firstPlayerElement = driver.findElement(By.className("first-player"));
        assertTrue(firstPlayerElement.isDisplayed(), "First player name is not displayed");
    }

    @Test
    public void testPageTitle() {
        driver.get("http://localhost:8080/players");
        String expectedTitle = "Players"; // Change this to the expected title
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Page title does not match expected title");
    }

    @Test
    public void testLoginButtonText() {
        driver.get("http://localhost:8080/login");
        WebElement loginButton = driver.findElement(By.id("loginButton")); // Assuming the login button has id 'loginButton'
        String expectedButtonText = "Logga in"; // Change this to the expected button text
        assertEquals(expectedButtonText, loginButton.getText(), "Login button text is incorrect");
    }
}
