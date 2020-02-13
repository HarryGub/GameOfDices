package GameOfDice;

public class Main {

    public static void main(String[] args) {
        int n, k, m;
        try {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
            m = Integer.parseInt(args[2]);
            if (!((n >= 2 && n <= 6) && (k >= 2 && k <= 5) && (m >= 1 && m <= 100)))
                throw new IllegalArgumentException();
            Game game = new Game();
            game.Play(n, k, m);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong arguments. N, K, M are integer values.");
            System.out.println("2 <= N <= 6, 2 <= K <= 5, 1 <= M <= 100");
        } catch (Exception e){
            System.out.println("Something went wrong!");
        }
    }
}
