package se.reky.hakan.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActorTest {

    private Player player;
    private Goblin goblin;

    @BeforeEach
    public void setUp() {
        player = new Player("Player", 100, 10);
        goblin = new Goblin("Goblin", 50, 5);
    }

    // Test for attack method to ensure it decreases the target's HP correctly
    @Test
    public void testAttack() {
        int initialHp = goblin.getHp();
        player.attack(goblin);
        Assertions.assertEquals(initialHp - player.getDamage(), goblin.getHp());
    }

}
