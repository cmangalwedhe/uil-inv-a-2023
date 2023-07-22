import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Cho {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(new File("cho.dat"));
        int N = kb.nextInt(); kb.nextLine();

        for (int i = 0; i < N; i++) {
            TreeMap<Character, Integer> map = new TreeMap<>();
            String line = kb.nextLine().replaceAll("\\W+", "");

            for (char c: line.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            char max = ' ';
            int maxLen = Integer.MIN_VALUE;

            for (char c: map.keySet()) {
                if (map.get(c) > maxLen) {
                    max = c;
                    maxLen = map.get(c);
                }
            }

            System.out.println(max);
        }
    }
}
