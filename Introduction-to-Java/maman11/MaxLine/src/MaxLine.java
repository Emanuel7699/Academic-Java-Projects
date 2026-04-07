/* This program accepts three points in a plane
and finds the greatest distance between two points.*/

import java.util.Scanner;
public class MaxLine
{
    public static void main(String[] args)
    {
        final byte SQUARE_ROOT = 2;
        Scanner scan = new Scanner(System.in);

        /* points created from the user */
        System.out.println("Enter first point coordinates:");//point A
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        System.out.println("Enter second point coordinates:");//point B
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        System.out.println("Enter third point coordinates:");//point C
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();


        /*distances between points*/
        double distance_AB = Math.sqrt(Math.pow((x1-x2),SQUARE_ROOT)+Math.pow((y1-y2),SQUARE_ROOT));
        double distance_BC = Math.sqrt(Math.pow((x2-x3),SQUARE_ROOT)+Math.pow((y2-y3),SQUARE_ROOT));
        double distance_AC = Math.sqrt(Math.pow((x1-x3),SQUARE_ROOT)+Math.pow((y1-y3),SQUARE_ROOT));



        if ((distance_AB >= distance_AC) && (distance_AB >= distance_BC))
        {
            System.out.println("Max line created by the following points: ("+x1+","+y1+"), ("+x2+","+y2+").");
        }

        else if ((distance_BC >= distance_AB) && (distance_BC >= distance_AC))
        {
            System.out.println("Max line created by the following points: ("+x2+","+y2+"), ("+x3+","+y3+").");

        }

        else
        {
            System.out.println("Max line created by the following points: ("+x1+","+y1+"), ("+x3+","+y3+").");
        }
    } // end of method main
} //end of class MaxLine