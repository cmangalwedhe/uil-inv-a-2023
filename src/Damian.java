import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Damian {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("damian.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            int num = file.nextInt();
            ArrayList<Integer> factors = new ArrayList<>();

            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    factors.add(j);
                }
            }

            ArrayList<Integer> growing = new ArrayList<>();

            for (Integer factor : factors) {
                if (isGrowing(factor))
                    growing.add(factor);
            }

            StringBuilder out = new StringBuilder();

            for (int j: growing) {
                out.append(j).append(" ");
            }

            System.out.println(out.toString().trim());
        }
    }

    public static boolean isGrowing(int factor) {
        String val = String.valueOf(factor);

        for (int i = 0; i < val.length() - 1; i++) {
            if (Integer.parseInt(val.substring(i, i+1)) >= Integer.parseInt(val.substring(i+1, i+2)))
                return false;
        }

        return true;
    }
}
