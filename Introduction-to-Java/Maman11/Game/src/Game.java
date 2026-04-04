/*"rock, paper and scissors" game.
  The program receives one letter from each player
  and brings a result according to the game "rock, paper and scissors" */

import java.util.Scanner;
public class Game
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter first player's object:");//Input to player 1.
        char player1 = scan.next().charAt(0);
        System.out.println("Enter second player's object:");//Input to player 2.
        char player2 = scan.next().charAt(0);

        if ((player1 == 'R' && player2 == 'S')||(player1 == 'P' && player2 == 'R')||(player1 == 'S' && player2 == 'P'))// The condition that player 1 win.
        {
            System.out.println("Player 1 wins.");
        }
        else if ((player1 == 'S' && player2 == 'R')||(player1 == 'R' && player2 == 'P')||(player1 == 'P' && player2 == 'S'))// The condition that player 2 win.
        {
            System.out.println("Player 2 wins.");
        }
        else
        {
            System.out.println("Game ends with a tie.");
        }
    } // end of method main
} //end of class Game
