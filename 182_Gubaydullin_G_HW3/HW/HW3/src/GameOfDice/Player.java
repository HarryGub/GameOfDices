package GameOfDice;

public class Player extends Thread {
    private int score;
    private int lastSum;
    private int id;
    private String playerName;
    private boolean roll;

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (Game.getDices()) {
                if (roll) {
                    roll = false;
                    Game.SetCurrent(this);
                }
            }
        }
    }

    public Player(int id) {
        score = 0;
        lastSum = 0;
        playerName = "Player " + id;
        roll = true;
        this.id = id - 1;
    }

    public void setRoll(boolean start) {
        roll = start;
    }

    public void Win() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getLastSum() {
        return lastSum;
    }

    public void throwDices() {
        lastSum = 0;
        for (Dice elem : Game.getDices())
            lastSum += elem.throwDice();
    }
}
