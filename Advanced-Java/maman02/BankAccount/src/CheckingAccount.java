// Represents a checking account that allows writing checks
public abstract class CheckingAccount extends BankAccount{

    // Constructor with all fields
    public CheckingAccount(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
    }

    // Writes a check - subtracts amount from balance, throws error if not enough money
    public void writeCheck(double amount) throws IllegalBalance {
        subtractBalance(amount);
    }
}