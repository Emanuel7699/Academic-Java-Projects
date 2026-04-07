// Represents a savings account that earns interest
public class SavingsAccount extends BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.01;
    private double _interestRate;


    // Constructor - uses default interest rate
    public SavingsAccount(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        this._interestRate = DEFAULT_INTEREST_RATE;
    }

    // Constructor - uses specified interest rate
    public SavingsAccount(String accountNumber, String accountHolderName,
                            String idNumber, double balance, double interestRate) {
        super(accountNumber, accountHolderName, idNumber, balance);
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
        if (!(obj instanceof SavingsAccount)) return false;
        if (!super.equals(obj)) return false;
        SavingsAccount other = (SavingsAccount) obj;
        return _interestRate == other._interestRate;
    }
}
