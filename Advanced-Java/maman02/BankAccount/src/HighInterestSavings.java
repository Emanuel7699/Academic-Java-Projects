// Represents a high interest savings account with a minimum balance requirement
public class HighInterestSavings extends SavingsAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.05; // Default interest rate (higher than regular savings account)
    private static final double DEFAULT_MINIMUM_BALANCE = 100.0; // Default minimum balance
    private double _minimumBalance;


    // Constructor - uses default interest rate and minimum balance
    public HighInterestSavings(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance, DEFAULT_INTEREST_RATE);
        this._minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    // Constructor - uses specified interest rate and minimum balance
    public HighInterestSavings(String accountNumber, String accountHolderName,
                          String idNumber, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolderName, idNumber, balance, interestRate);
        this._minimumBalance = minimumBalance;
    }

    // Subtracts amount from balance, throws error if not enough money
    @Override
    public void subtractBalance(double amount) throws IllegalBalance {
        if (getBalance() - amount < _minimumBalance) {
            throw new IllegalBalance("Action denied: High interest savings must maintain minimum balance of " + _minimumBalance);
        }
        super.subtractBalance(amount);
    }

    // Getters and setters
    public double getMinBalance() {
        return _minimumBalance;
    }

    public void setMinBalance(double minBalance) {
        this._minimumBalance = minBalance;
    }

    // Returns account details as a string
    @Override
    public String toString() {
        return super.toString() + "\nMinimum Balance Required: " + _minimumBalance;
    }

    // Checks if two accounts are equal
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HighInterestSavings)) return false;
        HighInterestSavings other = (HighInterestSavings) obj;
        return this._minimumBalance == other._minimumBalance;
    }
}
