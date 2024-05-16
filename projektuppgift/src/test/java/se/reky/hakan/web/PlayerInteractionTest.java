package se.reky.hakan.web;

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

@Nested
class PlayerInteractionTest {

    private SimplePlayerInteraction playerInteraction;
    private Player player;

    private void setUp() {
        // Create an IOHandler instance for SimplePlayerInteraction constructor
        InputStream inputStream = new ByteArrayInputStream("John\n".getBytes()); // Provide mock input
        Scanner scanner = new Scanner(inputStream);
        IOHandler ioHandler = new IOHandler(scanner);

        // Initialize SimplePlayerInteraction with the created IOHandler
        playerInteraction = new SimplePlayerInteraction(ioHandler);
        player = new Player("John", 100, 10);
    }

    @Test
    public void testSomeInteraction() {
        setUp(); // Call setUp() before each test method
        // Test logic here
        assertNotNull(playerInteraction);
        assertNotNull(player);
    }

    @Test
    public void testAnotherInteraction() {
        setUp(); // Call setUp() before each test method
        // Another test logic here
        assertNotNull(playerInteraction);
        assertNotNull(player);
    }

    // Test for setupPlayer method to ensure it sets player's name correctly
    @Test
    public void testSetupPlayer() {
        setUp(); // Call setUp() before each test method
        // Act
        playerInteraction.setupPlayer(player);

        // Assert
        Assertions.assertEquals("John", player.getName());
    }

    // Test for updatePlayerHealth method to ensure it updates player's health correctly
    @Test
    public void testUpdatePlayerHealth() {
        setUp(); // Call setUp() before each test method
        // Arrange
        int initialHealth = player.getHp();
        int healthUpdate = 10;

        // Act
        playerInteraction.updatePlayerHealth(player, healthUpdate);

        // Assert
        Assertions.assertEquals(initialHealth + healthUpdate, player.getHp());
    }
}
