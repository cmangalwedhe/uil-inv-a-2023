import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Himanshu {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("himanshu.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            int dimensions = file.nextInt();
            file.nextLine();

            ArrayList<String> gameBoard = new ArrayList<>();

            for (int j = 0; j < dimensions; j++) {
                ArrayList<String> line = new ArrayList<>();

                for (int k = 0; k < dimensions; k++) {
                    line.add(file.next());
                }

                if ((dimensions - j) % 2 == 1) {
                    Collections.reverse(line);
                }

                gameBoard.addAll(line);
            }

            Collections.reverse(gameBoard);

            HashMap<String, Integer> complements = new HashMap<>();
            HashMap<Integer, Integer> ladders = new HashMap<>();
            HashMap<Integer, Integer> snakes = new HashMap<>();

            for (int j = 0; j < dimensions * dimensions; j++) {
                String spot = gameBoard.get(j);

                if (spot.contains("L")) {
                    if (complements.containsKey(spot)) ladders.put(complements.get(spot), j);
                    else complements.put(spot, j);
                }
            }

            complements.clear();

            for (int j = dimensions * dimensions - 1; j >= 0; j--) {
                String spot = gameBoard.get(j);

                if (spot.contains("S")) {
                    if (complements.containsKey(spot)) snakes.put(complements.get(spot), j);
                    else complements.put(spot, j);
                }
            }

            file.nextLine();
            String[] playerOneMoves = file.nextLine().split("[,\\:]");
            String[] playerTwoMoves = file.nextLine().split("[,\\:]");

            int scoreOne = 0, scoreTwo = 0;
            boolean aWon = false, bWon = false;

            for (int j = 0; j <= playerOneMoves.length; j++) {
                int playerOne = j == 0 || j == playerOneMoves.length ? 0 : Integer.parseInt(playerOneMoves[j]);
                int playerTwo = j == 0 || j == playerOneMoves.length ? 0 : Integer.parseInt(playerTwoMoves[j]);

                scoreOne += playerOne;

                if (snakes.containsKey(scoreOne)) {
                    scoreOne = snakes.get(scoreOne);
                } else if (ladders.containsKey(scoreOne)) {
                    scoreOne = ladders.get(scoreOne);
                }

                if (scoreOne >= dimensions * dimensions - 1) {
                    aWon = true;
                }

                scoreTwo += playerTwo;

                if (snakes.containsKey(scoreTwo))
                    scoreTwo = snakes.get(scoreTwo);
                else if (ladders.containsKey(scoreTwo))
                    scoreTwo = ladders.get(scoreTwo);

                if (scoreTwo >= dimensions * dimensions - 1) {
                    bWon = true;
                }

                if (aWon || bWon) break;
            }

            System.out.printf("Game #%d: ", i+1);
            if (aWon && bWon) System.out.println("Both players win!");
            else if (aWon) System.out.println("Player 1 wins!");
            else if (bWon) System.out.println("Player 2 wins!");
            else System.out.println("Neither Player 1 or Player 2 won.");
            file.nextLine();
        }
    }
}
