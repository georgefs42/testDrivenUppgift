package se.reky.hakan.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

public class GameUtilTest {

    // Test for toLowerCaseButFirstLetterCapitalized method with null input
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_NullInput() {
        GameUtil gameUtil = new GameUtil();
        Assertions.assertThrows( GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized(null);
        });
    }

    // Test for toLowerCaseButFirstLetterCapitalized method with empty input
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_EmptyInput() {
        GameUtil gameUtil = new GameUtil();
        Assertions.assertThrows(GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized("");
        });
    }

    // Test for toLowerCaseButFirstLetterCapitalized method with valid input
    @Test
    public void testToLowerCaseButFirstLetterCapitalized_ValidInput() throws GameException {
        GameUtil gameUtil = new GameUtil();
        Assertions.assertEquals("Hello", gameUtil.toLowerCaseButFirstLetterCapitalized("HELLO"));
    }

}
