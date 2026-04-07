/**This class save history of guesses.
 *
 */
public class GuessNode {
    private String number;
    private int bulls;
    private int cows;
    private GuessNode next;

    /**The function that saved new guess.
     *
     * @param number
     * @param bulls
     * @param cows
     */
    public GuessNode(String number, int bulls, int cows) {
        this.number = number;
        this.bulls = bulls;
        this.cows = cows;
        this.next = null;
    }

    /**This function returns the number of bulls in the guess.
     *
     * @return the number of bulls
     */
    public int getBulls() {
        return bulls;
    }

    /**This function returns the number of cows in the guess.
     *
     * @return the number of cows
     */
    public int getCows() {
        return cows;
    }

    /**This function returns the next node in the history list.
     *
     * @return the next GuessNode
     */
    public GuessNode getNext() {
        return next;
    }

    /**This function returns the guessed number string.
     *
     * @return the guessed number
     */
    public String getNumber() {
        return number;
    }

    /**This function sets the pointer to the next node in the history list.
     *
     * @param next the next GuessNode to be linked
     */
    public void setNext(GuessNode next) {
        this.next = next;
    }
}