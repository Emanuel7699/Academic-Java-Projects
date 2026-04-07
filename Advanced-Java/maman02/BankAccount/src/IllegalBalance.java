// Custom exception for illegal balance operations
public class IllegalBalance extends Exception{
    public IllegalBalance() {
        super();
    }

    public IllegalBalance(String message) {
        super(message);
    }
}