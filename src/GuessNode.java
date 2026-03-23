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

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public GuessNode getNext() {
        return next;
    }

    public String getNumber() {
        return number;
    }

    public void setNext(GuessNode next) {
        this.next = next;
    }
}