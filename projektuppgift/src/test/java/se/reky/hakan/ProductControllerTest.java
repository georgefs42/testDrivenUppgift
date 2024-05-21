package se.reky.hakan;

// Importera nödvändiga klasser från Selenium och JUnit
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

// Använd TestInstance för att dela samma instans av testklassen över alla tester
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

    // Deklarera WebDriver och WebDriverWait som instansvariabler
    private WebDriver driver;
    private WebDriverWait wait;

    // Metoden som körs en gång före alla tester
    @BeforeAll
    public void setUp() {
        // Konfigurera WebDriverManager för Chrome
        WebDriverManager.chromedriver().setup();

        // Initiera ChromeDriver
        driver = new ChromeDriver();

        // Initiera WebDriverWait med en timeout på 10 sekunder
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigera till test-URL:en
        driver.get("http://localhost:8080/players");
    }

    // Testar att antal spelare i listan är korrekt
    @Test
    public void testPlayerListCount() {
        // Vänta tills spelarlistan är synlig
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".player")));

        // Verifiera att antalet spelare i listan är som förväntat
        int expectedPlayerCount = 2; // Ändra enligt ditt testscenario
        int actualPlayerCount = driver.findElements(By.cssSelector(".player")).size();
        assertEquals(expectedPlayerCount, actualPlayerCount);
    }

    // Testar att namnet på första spelaren visas
    @Test
    public void testFirstPlayerNameDisplayed() {
        // Vänta tills namnet på första spelaren är synligt
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".player:nth-of-type(1) .name")));

        // Verifiera att namnet på första spelaren visas på sidan
        WebElement firstPlayerName = driver.findElement(By.cssSelector(".player:nth-of-type(1) .name"));
        assertTrue(firstPlayerName.isDisplayed());
    }

    // Testar att sidtiteln är korrekt
    @Test
    public void testPageTitle() {
        // Vänta tills sidtiteln innehåller det förväntade värdet
        wait.until(ExpectedConditions.titleContains("Your Expected Title"));

        // Testa att sidtiteln matchar det förväntade värdet
        String expectedTitle = "Your Expected Title";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    // Testar att login-knappen är korrekt
    @Test
    public void testLoginButton() {
        // Vänta tills login-knappen är synlig
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));

        // Testa att login-knappen har den förväntade texten
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        String expectedButtonText = "Logga in";
        assertEquals(expectedButtonText, loginButton.getText());
    }

    // Metoden som körs en gång efter alla tester
    @AfterAll
    public void tearDown() {
        // Stäng WebDriver efter att alla tester är klara
        if (driver != null) {
            driver.quit();
        }
    }
}
