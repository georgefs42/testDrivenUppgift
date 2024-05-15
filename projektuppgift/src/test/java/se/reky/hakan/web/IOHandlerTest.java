package se.reky.hakan.web;

import org.junit.jupiter.api.Test;
import se.reky.hakan.IOHandler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class IOHandlerTest {

    @Test
    public void testScannerNextLine() {
        String input = "Hello, World!";
        Scanner scanner = new Scanner(input);
        assertEquals(input, scanner.nextLine(), "The nextLine() method did not return the expected input");
    }

    @Test
    public void testHasNextInt() {
        String input = "42";
        Scanner scanner = new Scanner(input);
        IOHandler ioHandler = new IOHandler(scanner);
        assertTrue(ioHandler.hasNextInt(), "The hasNextInt() method did not return true for input that contains an integer");
    }

    @Test
    public void testNextInt() {
        String input = "42";
        Scanner scanner = new Scanner(input);
        IOHandler ioHandler = new IOHandler(scanner);
        assertEquals(42, ioHandler.nextInt(), "The nextInt() method did not return the expected integer");
    }

    // Private helper method to create IOHandler instance
    private IOHandler createIOHandlerWithInput(String input) {
        Scanner scanner = new Scanner(input);
        return new IOHandler(scanner);
    }

    @Test
    public void testPromptForNewGameYes() {
        IOHandler ioHandler = createIOHandlerWithInput("yes");
        assertTrue(ioHandler.promptForNewGame(), "The promptForNewGame() method did not return true for input 'yes'");
    }

    @Test
    public void testPromptForNewGameNo() {
        IOHandler ioHandler = createIOHandlerWithInput("no");
        assertFalse(ioHandler.promptForNewGame(), "The promptForNewGame() method did not return false for input 'no'");
    }

    @Test
    public void testPromptForContinueYes() {
        IOHandler ioHandler = createIOHandlerWithInput("yes");
        assertTrue(ioHandler.promptForContinue(), "The promptForContinue() method did not return true for input 'yes'");
    }

    @Test
    public void testPromptForContinueNo() {
        IOHandler ioHandler = createIOHandlerWithInput("no");
        assertFalse(ioHandler.promptForContinue(), "The promptForContinue() method did not return false for input 'no'");
    }

}
