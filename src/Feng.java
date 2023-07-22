import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Feng {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("feng.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            String[] split = file.next().split(":");

            double hr = Integer.parseInt(split[0]);
            double min = Integer.parseInt(split[1]);

            hr = hr <= 3 ? 3 - hr : 15 - hr;
            double cmin = min <= 15 ? 15 - min : 75 - min;
            double d = hr * 30 - min / 2;

            if (d < 0)
                d = 360 + d;

            System.out.printf("Hour: %.1f Minute: %.1f\n", d, cmin * 6);
        }
    }
}
