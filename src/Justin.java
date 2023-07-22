import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Justin {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("justin.dat"));
        int N = file.nextInt();

        for (int i = 0; i < N; i++) {
            double purchasePrice = file.nextDouble();
            double downPayment = file.nextDouble();
            double APR = file.nextDouble();
            int monthlyPayments = file.nextInt();

            double a = purchasePrice - downPayment;
            double r = APR / 12 / 100;

            double monthlyPayment = (a * r) / (1 - Math.pow(1 + r, -monthlyPayments));
            monthlyPayment = Math.round(monthlyPayment * 100) / 100.;

            double finalCost = monthlyPayment * monthlyPayments + downPayment;
            finalCost = Math.round(finalCost * 100) / 100.;

            double interestPaid = finalCost - purchasePrice;
            interestPaid = Math.round(interestPaid * 100) / 100.;

            System.out.printf("$%9.2f $%9.2f $%9.2f\n", monthlyPayment, finalCost, interestPaid);
        }
    }
}
