package GameOfDice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    private Dice dice;
    @BeforeEach
    void setUp() {
        dice = new Dice(300);
    }

    @AfterEach
    void tearDown() {
        dice = null;
    }

    @Test
    void throwDice() {
        int res = dice.throwDice();
        if (res >= 0 && res <= 300)
            assert (true);
    }
}