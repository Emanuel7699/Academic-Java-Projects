import java.util.Random;

/**This class contains all the functions required for the game.
 *
 */
public class TheGame {

    private GuessNode head;
    private String secretNumber;
    private int attempts;
    final int LIMIT_MAX_DIGIT = 10;
    final int FIRST_DIGIT = 0;
    final int LENGTH_OF_NUMBER = 4;
    final int ERROR = -1;
    final int WIN = 0;
    final int PARTIAL_WIN = 1;
    final int CORRECT = 4;


    public TheGame() {
        this.secretNumber = randomNumber();
        this.head = null;
        this.attempts = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    /**This function create a random number and test it if it correct,
     * if not, it creates another random number.
     * @return a random number
     */
    private String randomNumber() {
        Random rand = new Random();
        int digit;
        String result = "";

        do {
            digit = rand.nextInt(LIMIT_MAX_DIGIT);

            if (result.isEmpty() && digit == FIRST_DIGIT) {
                continue;
            }

            if (result.indexOf((char) (digit + '0')) == -1) {
                result += (char) (digit + '0');
            }
        } while (result.length() < LENGTH_OF_NUMBER);
        return result;
    }

    /**This function validates the user's guess against the secret number and calculates bulls and cows.
     * if the number is invalid, it returns -1
     *
     * @param number from the user
     * @return 0 If the guess was successful, 1 if not.
     */
    public int checkNumber(String number) {
        int bull = 0, cow = 0;
        if (number.length() != LENGTH_OF_NUMBER) {
            return ERROR;
        }
        for (int i = 0; i < this.secretNumber.length(); i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                return ERROR;
            }
            if (number.charAt(i) == this.secretNumber.charAt(i)) {
                bull++;
            } else {
                for (int j = 0; j < this.secretNumber.length(); j++) {
                    if (number.charAt(i) == number.charAt(j) && i != j) {
                        return ERROR;
                    }
                    if (number.charAt(i) == this.secretNumber.charAt(j)) {
                        cow++;
                    }
                }
            }
        }
        this.attempts++;
        if (bull != CORRECT) {
            add(number, bull, cow);
            return PARTIAL_WIN;
        }
        return WIN;
    }

    /**This function save the guess into the linked list.
     *
     * @param number
     * @param bulls
     * @param cows
     */
    private void add(String number, int bulls, int cows) {
        GuessNode newNode = new GuessNode(number, bulls, cows);

        if (head == null) {
            head = newNode;
            return;
        }

        GuessNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    /**This function get the history of all guesses and sends to print to the user.
     *
     * @return string of history guesses
     */
    public String getHistory() {
        GuessNode current = head;
        String history = "";

        while (current != null) {
            history = history + (
                    "Number: " + current.getNumber() +
                            " | Bulls: " + current.getBulls() +
                            " | Cows: " + current.getCows() + "\n"
            );
            current = current.getNext();
        }
        return history;
    }
}