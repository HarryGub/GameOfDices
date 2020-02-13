package GameOfDice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    private Player player;
    private int id = 228;

    @BeforeEach
    void setUp() {
        player = new Player(id);
        Field field = null;
        List<Dice> dices = new ArrayList<Dice>();
        for (int i = 0; i < 4; ++i)
            dices.add(new Dice(6));
        try {
            field = Game.class.getDeclaredField("dices");
            field.setAccessible(true);
            field.set(Game.class, dices);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        player = null;
    }

    @Test
    void Win() {
        player.Win();
        assertEquals(1, player.getScore());
    }

    @Test
    void getPlayerName() {
        assertEquals("Player 228", player.getPlayerName());
    }

    @Test
    void throwDices() {
        player.throwDices();
        if (player.getLastSum() >= 4 && player.getLastSum() <= 24)
            assert (true);
    }
}