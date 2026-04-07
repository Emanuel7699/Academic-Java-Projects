public abstract class BankAccount {


    private String _accountNumber, _accountHolderName, _idNumber;
    private double _balance;

    // Default constructor
    public BankAccount()
    {
        _accountNumber = "";
        _accountHolderName = "";
        _idNumber = "";
        _balance = 0;
    }

    // Constructor with all fields
    public BankAccount(String _accountNumber, String _accountHolderName, String _idNumber,
                       double _balance)
    {
        this._accountNumber = _accountNumber;
        this._accountHolderName = _accountHolderName;
        this._idNumber = _idNumber;
        this._balance = _balance;
    }

    // Adds amount to the balance
    public void addBalance(double amount) {
        this._balance += amount;
    }

    // Subtracts amount from the balance, throws error if not enough money
    public void subtractBalance(double amount) throws IllegalBalance{
        if(amount > this._balance) throw new IllegalBalance ("Error: Insufficient balance");
        this._balance -= amount;
    }


    public abstract void monthlyManagement() throws IllegalBalance;

    // Returns account details as a string
    public String toString(){
        String str = "";
        str += "Account Number: " + _accountNumber + "\n";
        str += "Account Holder Name: " + _accountHolderName + "\n";
        str += "ID Number: " + _idNumber + "\n";
        str += "Balance: " + _balance;
        return str;
    }

    // Checks if two accounts are equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        BankAccount other = (BankAccount) obj;

        return _accountNumber.equals(other._accountNumber) &&
                _accountHolderName.equals(other._accountHolderName) &&
                _idNumber.equals(other._idNumber) &&
                _balance == other._balance;
    }

    // Getters and setters
    public String getAccountNumber() {
        return _accountNumber;
    }
    public String getAccountHolderName() {
        return _accountHolderName;
    }
    public String getIdNumber() {
        return _idNumber;
    }
    public double getBalance() {
        return _balance;
    }

    public void setAccountNumber(String _accountNumber) {
        this._accountNumber = _accountNumber;
    }
    public void setAccountHolderName(String _accountHolderName) {
        this._accountHolderName = _accountHolderName;
    }
    public void setIdNumber(String _idNumber) {
        this._idNumber = _idNumber;
    }
    public void setBalance(double _balance) {
        this._balance = _balance;
    }
}
