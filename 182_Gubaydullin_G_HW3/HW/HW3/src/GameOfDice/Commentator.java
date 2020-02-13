package GameOfDice;

import java.util.Comparator;
import java.util.List;

public class Commentator{

    public void tellPlayerResult(Player player, Player leader){
        System.out.println(player.getPlayerName() + " threw away " + player.getLastSum() + "\nLeader is " + leader.getPlayerName() + " with result of " + leader.getLastSum());
    }

    public void tellScoreTable(List<Player> playerList, Player roundWinner, Player currentPlayer){
        if(!Game.END()) {
            System.out.println(currentPlayer.getPlayerName() + " threw away " + currentPlayer.getLastSum());
            System.out.println(roundWinner.getPlayerName() + " won this round! He has already " + roundWinner.getScore() + " win(s)");
        } else {
            playerList.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return ((Integer)(o2.getScore())).compareTo(o1.getScore());
                }
            });
            System.out.println(currentPlayer.getPlayerName() + " threw away " + currentPlayer.getLastSum() + "\n" + playerList.get(0).getPlayerName() + " won this game!!!");
            int i = 1;
            System.out.println("Score table:");
            for (Player elem : playerList) {
                System.out.println(i + ".\t" + elem.getPlayerName() + " " + elem.getScore());
                i++;
            }
        }
    }
}
