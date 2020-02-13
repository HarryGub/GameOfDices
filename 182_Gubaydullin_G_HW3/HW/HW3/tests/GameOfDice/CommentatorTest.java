package GameOfDice;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommentatorTest {

    @Test
    void tellPlayerResult() {
        Player player1 = new Player(23);
        Player player2 = new Player(32);
        Commentator com = new Commentator();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        com.tellPlayerResult(player1, player2);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        String current = buffer.toString();
        System.out.println(current);
        buffer.reset();
        String needed = player1.getPlayerName() + " threw away " + player1.getLastSum() + "\nLeader is " + player2.getPlayerName() + " with result of " + player2.getLastSum() + "\n";
        if(needed.equals(current))
            assert(true);
    }

    @Test
    void tellScoreTable() {
        Game game = new Game();
        game.Play(2,2,0);
        Player player1 = new Player(23);
        Player player2 = new Player(32);
        Commentator com = new Commentator();
        List<Player> players = new ArrayList<Player>(2);
        players.add(player1);
        players.add(player2);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        com.tellScoreTable(players, player1, player2);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        String current = buffer.toString();
        System.out.println(current);
        buffer.reset();
        String needed = player2.getPlayerName() + " threw away " + player2.getLastSum() + "\n" + players.get(0).getPlayerName() + " won this game!!!";
        needed += "\nScore table:\n";
        needed += "1.\t" + players.get(0).getPlayerName() + " " + players.get(0).getScore() + "\n";
        needed += "2.\t" + players.get(1).getPlayerName() + " " + players.get(1).getScore() + "\n";
        if(needed.equals(current))
            assert(true);
    }
}