// Represents a checking account with no service charge but a minimum balance requirement

public class NoServiceChargeChecking extends CheckingAccount{
    private static final double DEFAULT_MINIMUM_BALANCE = 10.0;
    private double _minimumBalance;

    // Constructor - uses default minimum balance
    public NoServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        _minimumBalance = DEFAULT_MINIMUM_BALANCE;
    }

    // Constructor - uses specified minimum balance
    public NoServiceChargeChecking(String accountNumber, String accountHolderName,
                                 String idNumber, double balance, double minimumBalance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        _minimumBalance = minimumBalance;
    }

    @Override
    public void monthlyManagement() throws IllegalBalance {}

    // Getters and Setters
    public double getMinimumBalance() {
        return _minimumBalance;
    }

    public void setMinimumBalance(double _minimumBalance) {
        this._minimumBalance = _minimumBalance;
    }

    // Subtracts amount from balance, throws error if not enough money
    @Override
    public void subtractBalance(double amount) throws IllegalBalance {
        if ((getBalance() - amount) < _minimumBalance) {
            throw new IllegalBalance("Action denied: Balance cannot drop below minimum: " + _minimumBalance);
        }
        super.subtractBalance(amount);
    }

    // Returns account details as a string
    @Override
    public String toString() {
        return super.toString() + "\nMinimum Balance: " + _minimumBalance;
    }

    // Checks if two accounts are equal
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NoServiceChargeChecking)) return false;
        if (!super.equals(obj)) return false;
        NoServiceChargeChecking other = (NoServiceChargeChecking) obj;
        return _minimumBalance == other._minimumBalance;
    }

}
