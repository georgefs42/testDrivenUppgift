package se.reky.hakan.web;

// Importerar nödvändiga klasser och paket från JUnit och projektet
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import se.reky.hakan.IOHandler;
import se.reky.hakan.SimplePlayerInteraction;
import se.reky.hakan.model.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Nested // Anger att denna klass innehåller grupperade tester
class PlayerInteractionTest {

    // Deklarerar instanser av SimplePlayerInteraction och Player
    private SimplePlayerInteraction playerInteraction;
    private Player player;

    // Metod för att sätta upp testmiljön innan varje test
    private void setUp() {
        // Skapar en IOHandler-instans för SimplePlayerInteraction-konstruktorn
        InputStream inputStream = new ByteArrayInputStream("John\n".getBytes()); // Tillhandahåller mock-input
        Scanner scanner = new Scanner(inputStream);
        IOHandler ioHandler = new IOHandler(scanner);

        // Initialiserar SimplePlayerInteraction med den skapade IOHandler
        playerInteraction = new SimplePlayerInteraction(ioHandler);
        player = new Player("John", 100, 10); // Skapar en ny Player-instans med namn, hp och attack
    }

    @Test // Markerar detta som ett testfall
    public void testSomeInteraction() {
        setUp(); // Anropar setUp() före varje testmetod
        // Testlogik här
        assertNotNull(playerInteraction); // Kontrollera att playerInteraction inte är null
        assertNotNull(player); // Kontrollera att player inte är null
    }

    @Test // Markerar detta som ett testfall
    public void testAnotherInteraction() {
        setUp(); // Anropar setUp() före varje testmetod
        // Annan testlogik här
        assertNotNull(playerInteraction); // Kontrollera att playerInteraction inte är null
        assertNotNull(player); // Kontrollera att player inte är null
    }

    // Test för setupPlayer-metoden för att säkerställa att den sätter spelarens namn korrekt
    @Test // Markerar detta som ett testfall
    public void testSetupPlayer() {
        setUp(); // Anropar setUp() före varje testmetod
        // Act - Anropar setupPlayer-metoden på playerInteraction
        playerInteraction.setupPlayer(player);

        // Assert - Kontrollera att spelarens namn är korrekt inställt
        Assertions.assertEquals("John", player.getName());
    }

    // Test för updatePlayerHealth-metoden för att säkerställa att den uppdaterar spelarens hälsa korrekt
    @Test // Markerar detta som ett testfall
    public void testUpdatePlayerHealth() {
        setUp(); // Anropar setUp() före varje testmetod
        // Arrange - Initiala hälsovärden
        int initialHealth = player.getHp(); // Spara spelarens initiala hälsa
        int healthUpdate = 10; // Definiera hälsouppdateringen

        // Act - Anropar updatePlayerHealth-metoden på playerInteraction
        playerInteraction.updatePlayerHealth(player, healthUpdate);

        // Assert - Kontrollera att spelarens hälsa har uppdaterats korrekt
        Assertions.assertEquals(initialHealth + healthUpdate, player.getHp());
    }
}
