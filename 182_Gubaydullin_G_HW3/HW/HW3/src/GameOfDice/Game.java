package GameOfDice;

import java.util.*;

public class Game {
    public static List<Player> playerList;
    public static Commentator commentator;
    public static List<Dice> dices;
    public static int n, k, m, count;
    public static Player current;
    public static Player winner;

    public static void SetCurrent(Player player) {
        ++count;
        current = player;
        if (!END()) {
            current.throwDices();
            if (winner == null || current.getLastSum() > winner.getLastSum())
                winner = current;
            if (winner.getLastSum() == k * 6) {
                count = n;
                for (Player elem : playerList)
                    elem.setRoll(false);
            }
            if (count != n) {
                commentator.tellPlayerResult(current, winner);
            } else {
                count = 0;
                winner.Win();
                commentator.tellScoreTable(playerList, winner, current);
                for (Player elem : playerList) {
                    elem.setRoll(true);
                }
                current = null;
                winner = null;
            }
        }
    }

    public static List<Dice> getDices() {
        return dices;
    }

    public void Play(int n, int k, int m) {
        this.n = n;
        this.k = k;
        this.m = m;
        count = 0;
        dices = new ArrayList<Dice>(k);
        playerList = new ArrayList<Player>(n);
        commentator = new Commentator();
        for (int i = 0; i < k; i++)
            dices.add(new Dice(6));
        for (int i = 0; i < n; i++) {
            playerList.add(new Player(i + 1));
            playerList.get(i).start();
        }
    }

    public static boolean END() {
        if (m == Collections.max(playerList, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return ((Integer) (o1.getScore())).compareTo(o2.getScore());
            }
        }).getScore()) {
            for (Player elem : playerList)
                elem.interrupt();
            return true;
        } else
            return false;
    }
}
