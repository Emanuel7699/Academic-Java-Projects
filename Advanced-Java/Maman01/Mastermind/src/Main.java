import javax.swing.*;

/**Bulls and cows game.
 * @author Emanuel Abraham
 * @version 23/03/2026 (2026b)
 */
void main() {
    int playAgain;

    do {
        TheGame game = new TheGame();
        int win = 1;
        int checkNumber;

        while (win != 0) {
            String history = game.getHistory();
            String input = JOptionPane.showInputDialog(null, history + "\nPlease enter 4 digit to guess the number: ");

            checkNumber = game.checkNumber(input);

            if (checkNumber == 0) {
                JOptionPane.showMessageDialog(null, "You won!\ntotal attempts: " + game.getAttempts());
                win = 0;
            }
            else  if (checkNumber == -1) {
                JOptionPane.showMessageDialog(null, "Invalid Number");
            }
        }

        playAgain = JOptionPane.showConfirmDialog(null, "Play again?");
    } while (playAgain == JOptionPane.OK_OPTION);
}