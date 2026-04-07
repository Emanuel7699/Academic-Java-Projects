/**Polynom.
 * @author Emanuel Abraham
 * @version 07/04/2026 (2026b)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // Get the number of terms in polynom 1
        System.out.println("Insert the Polynom-1 size");
        int n1 = sc.nextInt();
        double[] co1 = new double[n1];
        int[] ex1 = new int[n1];

        // Get coefficient and exponent for each term in polynom 1
        System.out.println("Enter pairs of coefficient and exponent:");
        for (int i = 0; i < n1; i++) {
            co1[i] = sc.nextDouble();
            ex1[i] = sc.nextInt();
        }

        // Get the number of terms in polynom 2
        System.out.println("Insert the Polynom-2 size");
        int n2 = sc.nextInt();
        double[] co2 = new double[n2];
        int[] ex2 = new int[n2];
        System.out.println("Enter pairs of coefficient and exponent:");
        for (int i = 0; i < n2; i++) {

            co2[i] = sc.nextDouble();
            ex2[i] = sc.nextInt();
        }

        try {
            // Create the two polynoms
            Polynom p1 = new Polynom(co1, ex1);
            Polynom p2 = new Polynom(co2, ex2);
            // Print both polynoms and their operations
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
            System.out.println("p1 + p2 = " + p1.plus(p2));
            System.out.println("p1 - p2 = " + p1.minus(p2));
            System.out.println("p1' = " + p1.derivative());
            System.out.println("p2' = " + p2.derivative());
            System.out.println("p1.equals(p2) = " + p1.equals(p2));
        } catch (Exception e) {
            // Print error if arrays are not the same length
            System.out.println("Error: Arrays must be the same length");
        }
    }
}