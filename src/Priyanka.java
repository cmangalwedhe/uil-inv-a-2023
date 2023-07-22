import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Priyanka {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("priyanka.dat"));
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(wordCheck(in.next()));
        }
    }

    public static String wordCheck(String word) {
        ArrayList<String> vowels = new ArrayList<>();
        ArrayList<String> consonants = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if ("AEIOU".contains(word.substring(i, i+1))) {
                vowels.add(word.substring(i, i+1));
            } else {
                consonants.add(word.substring(i, i+1));
            }
        }

        vowels.sort(String::compareTo);
        Collections.reverse(vowels);

        consonants.sort(String::compareTo);

        String vowel = "";
        String consonant = "";

        for (String v: vowels) vowel += v;
        for (String c: consonants) consonant += c;

        if ((vowel + consonant).equals(word))
            return "WOO-HOO " + word;

        return vowel + consonant;
    }
}
