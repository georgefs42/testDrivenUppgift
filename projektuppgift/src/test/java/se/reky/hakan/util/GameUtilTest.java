package se.reky.hakan.util;

import org.junit.jupiter.api.Assertions; // Importerar Assertions-klass från JUnit 5
import org.junit.jupiter.api.Test; // Importerar Test-klass från JUnit 5
import se.reky.hakan.GameException; // Importerar GameException-klassen

public class GameUtilTest {

    // Testar metoden toLowerCaseButFirstLetterCapitalized med null-inmatning
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_NullInput() {
        GameUtil gameUtil = new GameUtil(); // Skapar en ny instans av GameUtil
        // Kontrollera att metoden kastar ett GameException när inmatningen är null
        Assertions.assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(null); // Anropar metoden med null-inmatning
        });
    }

    // Testar metoden toLowerCaseButFirstLetterCapitalized med tom inmatning
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_EmptyInput() {
        GameUtil gameUtil = new GameUtil(); // Skapar en ny instans av GameUtil
        // Kontrollera att metoden kastar ett GameException när inmatningen är en tom sträng
        Assertions.assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(""); // Anropar metoden med tom sträng som inmatning
        });
    }

    // Testar metoden toLowerCaseButFirstLetterCapitalized med giltig inmatning
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_ValidInput() throws GameException {
        GameUtil gameUtil = new GameUtil(); // Skapar en ny instans av GameUtil
        // Kontrollera att metoden returnerar "Hello" när inmatningen är "HELLO"
        Assertions.assertEquals("Hello", gameUtil.toLowerCaseButFirstLetterCapitalized("HELLO")); // Anropar metoden med giltig inmatning
    }

}
