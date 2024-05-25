package se.reky.hakan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Controller;

import java.util.List;

@Disabled
public class ProductControllerTest {

    ChromeDriver driver;  // Instance of ChromeDriver for browser automation

    @BeforeAll
    public static void init () {
        // Set up the ChromeDriver using WebDriverManager, which handles the binary for the appropriate version of ChromeDriver
        WebDriverManager.chromedriver ().setup ();
    }

    @BeforeEach
    public void setUp () {
        // Initialize the ChromeDriver instance before each test
        driver = new ChromeDriver ();
        // Navigate to the specified URL before each test
        driver.get ( "http://localhost:8080/players" );
    }



    @Test
    @DisplayName("List size should match played games")
    public void verifyNumberOfPlayers () {
        // Find all elements with the tag name "li" which represents the players in the list
        List<WebElement> playerList = driver.findElements ( By.tagName ( "li" ) );
        // Assert that the size of the player list is 1
        Assertions.assertEquals ( playerList.size (), 4 );
    }

    @Test
    @DisplayName("First element in list should be shown")
    public void verifyFirstNameOfPlayers () {
        // Find all elements with the tag name "li" which represents the players in the list
        List<WebElement> playerList = driver.findElements ( By.className ( "player-name" ) );
        // Find the first player's name by looking for the element with class name "player-name" within the first list item
        WebElement firstName = playerList.get ( 0 );
        // Assert that the first player's name is displayed
        Assertions.assertTrue ( firstName.isDisplayed (), "First name should be displayed" );
    }

    @Test
    @DisplayName("Title should match")
    public void verifyTitle () {
        // Assert that the title of the page is "Players List"
        Assertions.assertEquals ( "Players List", driver.getTitle () );
    }

    @Test
    @DisplayName("Button text should be - Logga in")
    public void verifyButtonText () {
        // Find the first button element on the page
        WebElement button = driver.findElement ( By.tagName ( "button" ) );
        // Assert that the button's text is "Logga in"
        Assertions.assertEquals ( "Logga in", button.getText () );
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit ();
        }
    }

}
