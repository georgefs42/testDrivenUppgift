package se.reky.hakan.model;

// Importera nödvändiga klasser från JUnit-biblioteket för enhetstester
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Skapa en testklass för att testa funktionaliteten hos Actor-klassen
public class ActorTest {

    // Deklarera instansvariabler för Player och Goblin objekt
    private Player player;
    private Goblin goblin;

    // Metoden som körs före varje test för att initiera testmiljön
    @BeforeEach
    public void setUp() {
        // Skapa ett nytt Player-objekt med namn, HP (hälsopoäng) och skada
        player = new Player("Player", 100, 10);
        // Skapa ett nytt Goblin-objekt med namn, HP och skada
        goblin = new Goblin("Goblin", 50, 5);
    }

    // Testmetod för att testa attack-metoden och se till att den minskar målets HP korrekt
    @Test
    public void testAttack() {
        // Spara initial HP för goblinen för att kunna jämföra senare
        int initialHp = goblin.getHp();
        // Spelaren attackerar goblinen
        player.attack(goblin);
        // Kontrollera att goblinens HP minskas med spelarens skada
        Assertions.assertEquals(initialHp - player.getDamage(), goblin.getHp());
    }

}
