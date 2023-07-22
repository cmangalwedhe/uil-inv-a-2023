import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Alan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("alan.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            double F = file.nextDouble();
            double K = 5./9*(F - 32) + 273.15;
            System.out.printf("%d degrees Fahrenheit is equal to %.2f Kelvin%n", (int) F, K);
        }
    }
}
