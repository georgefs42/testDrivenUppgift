package se.reky.hakan.web;

import org.junit.jupiter.api.Test; // Importerar JUnit 5 test-ramverket
import se.reky.hakan.IOHandler; // Importerar IOHandler-klassen som ska testas

import static org.junit.jupiter.api.Assertions.*; // Importerar assertions för tester

import java.util.Scanner; // Importerar Scanner-klassen för att läsa input

public class IOHandlerTest {

    // Testar Scanner-klassens nextLine() metod
    @Test
    public void testScannerNextLine() {
        String input = "Hello, World!"; // Definierar en sträng som input
        Scanner scanner = new Scanner(input); // Skapar en Scanner med input-strängen
        // Verifierar att Scanner.nextLine() returnerar den förväntade strängen
        assertEquals(input, scanner.nextLine(), "The nextLine() method did not return the expected input");
    }

    // Testar hasNextInt() metod i IOHandler
    @Test
    public void testHasNextInt() {
        String input = "42"; // Definierar en sträng som representerar ett heltal
        Scanner scanner = new Scanner(input); // Skapar en Scanner med input-strängen
        IOHandler ioHandler = new IOHandler(scanner); // Skapar en IOHandler med Scannern
        // Verifierar att IOHandler.hasNextInt() returnerar true för en sträng som innehåller ett heltal
        assertTrue(ioHandler.hasNextInt(), "The hasNextInt() method did not return true for input that contains an integer");
    }

    // Testar nextInt() metod i IOHandler
    @Test
    public void testNextInt() {
        String input = "42"; // Definierar en sträng som representerar ett heltal
        Scanner scanner = new Scanner(input); // Skapar en Scanner med input-strängen
        IOHandler ioHandler = new IOHandler(scanner); // Skapar en IOHandler med Scannern
        // Verifierar att IOHandler.nextInt() returnerar det förväntade heltalet
        assertEquals(42, ioHandler.nextInt(), "The nextInt() method did not return the expected integer");
    }

    // Privat hjälpmetod för att skapa en IOHandler-instans med given input
    private IOHandler createIOHandlerWithInput(String input) {
        Scanner scanner = new Scanner(input); // Skapar en Scanner med input-strängen
        return new IOHandler(scanner); // Returnerar en ny IOHandler med Scannern
    }

    // Testar promptForNewGame() metod i IOHandler för input "yes"
    @Test
    public void testPromptForNewGameYes() {
        IOHandler ioHandler = createIOHandlerWithInput("yes"); // Skapar en IOHandler med input "yes"
        // Verifierar att IOHandler.promptForNewGame() returnerar true för input "yes"
        assertTrue(ioHandler.promptForNewGame(), "The promptForNewGame() method did not return true for input 'yes'");
    }

    // Testar promptForNewGame() metod i IOHandler för input "no"
    @Test
    public void testPromptForNewGameNo() {
        IOHandler ioHandler = createIOHandlerWithInput("no"); // Skapar en IOHandler med input "no"
        // Verifierar att IOHandler.promptForNewGame() returnerar false för input "no"
        assertFalse(ioHandler.promptForNewGame(), "The promptForNewGame() method did not return false for input 'no'");
    }

    // Testar promptForContinue() metod i IOHandler för input "yes"
    @Test
    public void testPromptForContinueYes() {
        IOHandler ioHandler = createIOHandlerWithInput("yes"); // Skapar en IOHandler med input "yes"
        // Verifierar att IOHandler.promptForContinue() returnerar true för input "yes"
        assertTrue(ioHandler.promptForContinue(), "The promptForContinue() method did not return true for input 'yes'");
    }

    // Testar promptForContinue() metod i IOHandler för input "no"
    @Test
    public void testPromptForContinueNo() {
        IOHandler ioHandler = createIOHandlerWithInput("no"); // Skapar en IOHandler med input "no"
        // Verifierar att IOHandler.promptForContinue() returnerar false för input "no"
        assertFalse(ioHandler.promptForContinue(), "The promptForContinue() method did not return false for input 'no'");
    }
}
