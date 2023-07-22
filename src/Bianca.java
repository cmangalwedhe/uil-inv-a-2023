import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bianca {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("bianca.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.printf("%.2f%n", Math.hypot(file.nextDouble(), file.nextDouble()));
        }
    }
}
