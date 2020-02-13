package GameOfDice;

import java.util.Random;

public class Dice {
    private int amountofsides;

    public Dice(int sides){
        amountofsides = sides;
    }
    public int throwDice(){
        Random r = new Random();
        return 1 + r.nextInt(amountofsides);
    }
}
