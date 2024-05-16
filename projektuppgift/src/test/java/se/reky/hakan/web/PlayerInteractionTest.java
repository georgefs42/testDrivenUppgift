package se.reky.hakan.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.IOHandler;
import se.reky.hakan.PlayerInteraction;
import se.reky.hakan.SimplePlayerInteraction;
import se.reky.hakan.model.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerInteractionTest {

    private PlayerInteraction playerInteraction;
    private Player player;

    @BeforeEach
    public void setUp() {
        // Create an IOHandler instance for PlayerInteraction constructor
        InputStream inputStream = new ByteArrayInputStream("".getBytes());
        Scanner scanner = new Scanner(inputStream);
        IOHandler ioHandler = new IOHandler(scanner);

        // Initialize PlayerInteraction with the created IOHandler
        playerInteraction = new SimplePlayerInteraction (ioHandler);
        player = new Player();
    }

    @Test
    public void testSomeInteraction() {
        // Test logic here
        assertNotNull(playerInteraction);
        assertNotNull(player);
    }

    @Test
    public void testAnotherInteraction() {
        // Another test logic here
        assertNotNull(playerInteraction);
        assertNotNull(player);
    }

    // Test for setupPlayer method to ensure it sets player's name correctly
    /*@Test
    public void testSetupPlayer() {
        // Arrange
        String playerName = "John";
        player.setName(playerName);

        // Act
        playerInteraction.setupPlayer(player);

        // Assert
        Assertions.assertEquals(playerName, player.getName());
    }*/

    // Test for updatePlayerHealth method to ensure it updates player's health correctly
    @Test
    public void testUpdatePlayerHealth() {
        // Arrange
        int initialHealth = player.getHp();
        int healthUpdate = 10;

        // Act
        playerInteraction.updatePlayerHealth(player, healthUpdate);

        // Assert
        Assertions.assertEquals(initialHealth + healthUpdate, player.getHp());
    }
}
