import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Marek {
    static boolean infinity;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("A2023JudgeData\\marek.dat"));
        int N = in.nextInt();
        in.nextLine();
        String operators = "()*/+-";

        for (int i = 0; i < N; i++) {
            infinity = false;
            String[] split = in.nextLine().split(" ");

            Stack<Character> ops = new Stack<>();
            Stack<Integer> vals = new Stack<>();

            for (String a: split) {
                if (a.matches("\\d+")) {
                    vals.push(Integer.parseInt(a));
                } else if (a.equals("(")) {
                    ops.push(a.charAt(0));
                } else if (a.equals(")")) {
                    while (!ops.peek().equals('(')) {
                        vals.push(eval(ops.pop(), vals.pop(), vals.pop()));
                    }
                    ops.pop();
                } else if (operators.contains(a)) {
                    char b = a.charAt(0);
                    while (!ops.isEmpty() && precedence(b, ops.peek()))
                        vals.push(eval(ops.pop(), vals.pop(), vals.pop()));

                    ops.push(b);
                }
            }

            while (!ops.isEmpty()) {
                vals.push(eval(ops.pop(), vals.pop(), vals.pop()));
            }

            if (infinity) {
                System.out.println("Infinity.");
                continue;
            }

            System.out.println(vals.pop());
        }
    }

    public static int eval(char op, int valOne, int valTwo) {
        return switch (op) {
            case '+' -> valOne + valTwo;
            case '-' -> valTwo - valOne;
            case '*' -> valOne * valTwo;
            case '/' -> {
                if (valOne == 0) {
                    infinity = true;
                    yield 0;
                }

                yield valTwo / valOne;
            }

            default -> 0;
        };
    }

    public static boolean precedence(char opOne, char opTwo) {
        if (opTwo == '(' || opTwo == ')')
            return false;
        return (opOne != '*' && opOne != '/') || (opTwo != '+' && opTwo != '-');
    }
}