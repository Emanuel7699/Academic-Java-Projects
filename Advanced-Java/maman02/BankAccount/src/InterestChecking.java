// Represents a checking account that earns interest with a higher minimum balance
public class InterestChecking extends NoServiceChargeChecking {

    private static final double DEFAULT_MINIMUM_BALANCE = 50.0; // Default minimum balance (higher than NoServiceChargeChecking)
    private static final double DEFAULT_INTEREST_RATE = 0.01; // Default interest rate
    private double _interestRate;

    // Constructor - uses default minimum balance and interest rate
    public InterestChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance, DEFAULT_MINIMUM_BALANCE);
        this._interestRate = DEFAULT_INTEREST_RATE;
    }

    // Constructor - uses specified minimum balance and interest rate
    public InterestChecking(String accountNumber, String accountHolderName,
                                   String idNumber, double balance, double interestRate, double minBalance) {
        super(accountNumber, accountHolderName, idNumber, balance, minBalance);
        this._interestRate = interestRate;
    }

    // Interest calculation
    private double calculateInterest() {
        return getBalance() * _interestRate;
    }

    // Getters and setters
    public double getInterestRate() {
        return _interestRate;
    }

    public void setInterestRate(double _interestRate) {
        this._interestRate = _interestRate;
    }

    // Interest calculation
    @Override
    public void monthlyManagement() {
        addBalance(calculateInterest());
    }

    // Returns account details as a string
    @Override
    public String toString() {
        return super.toString() + "\nInterest Rate: " + _interestRate;
    }

    // Checks if two accounts are equal
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof InterestChecking)) return false;
        if (!super.equals(obj)) return false;
        InterestChecking other = (InterestChecking) obj;
        return _interestRate == other._interestRate;
    }
}