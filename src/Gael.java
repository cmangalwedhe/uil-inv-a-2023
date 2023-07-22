import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gael {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("gael.dat"));
        int N = kb.nextInt(); kb.nextLine();

        for (int i = 0; i < N; i++) {
            String line = kb.nextLine();
            StringBuilder out = new StringBuilder();

            out.append(line).append('\n');

            for (int j = 1; j < line.length()-1; j++) {
                out.append(line.charAt(j)).append(" ".repeat(line.length() - 2)).append(line.charAt(line.length() - 1 - j)).append('\n');
            }

            out.append(new StringBuilder(line).reverse());
            System.out.println(out);
        }
    }
}
