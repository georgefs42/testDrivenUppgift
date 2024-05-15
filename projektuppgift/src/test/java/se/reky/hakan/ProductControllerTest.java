package se.reky.hakan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Mark the entire class as disabled since these tests interact with the local application
@Disabled
public class ProductControllerTest {

    // Declare WebDriver as a class attribute to be instantiated and closed in test methods
    private WebDriver driver;

    // Method annotated with @BeforeAll to set up WebDriverManager before all tests
    @BeforeAll
    public static void setUpBeforeAll() {
        // Set up WebDriverManager
        WebDriverManager.chromedriver().setup();
    }

    // Method annotated with @BeforeEach to instantiate WebDriver before each test
    @BeforeEach
    public void setUpBeforeEach() {
        // Set up WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run Chrome in headless mode
        driver = new ChromeDriver(options);
    }

    // Method annotated with @AfterEach to close WebDriver after each test
    @AfterEach
    public void tearDown() {
        // Close WebDriver
        if (driver != null) {
            driver.quit();
        }
    }

    // Test method to verify some functionality of the ProductController
    @Test
    public void testProductController() {
        // Navigate to the URL
        driver.get("http://localhost:8080/players");

        // Example Selenium interactions
        String title = driver.getTitle();

        // Assert that the title contains expected text
        assertTrue(title.contains("Players"));
    }

}