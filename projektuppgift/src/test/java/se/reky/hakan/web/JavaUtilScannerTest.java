package se.reky.hakan.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaUtilScannerTest {

    @Test
    @DisplayName("Scanner takes in correct input")
    public void testScannerReturnsExpectedText() {
        String actualText = "test data";
        Scanner scanner = new Scanner(actualText);
        String expectedText = scanner.nextLine();
        assertEquals(actualText, expectedText);
    }
}