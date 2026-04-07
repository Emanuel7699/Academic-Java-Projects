// Represents a checking account with a monthly service charge
public class ServiceChargeChecking extends CheckingAccount{
    // Default service charge amount
    private final double DEFAULT_SERVICE_CHARGE = 10.0;
    private double _serviceCharge;

    // Constructor - uses default service charge
    public ServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double balance) {
        super(accountNumber, accountHolderName, idNumber, balance);
        _serviceCharge = DEFAULT_SERVICE_CHARGE;
    }

    // Constructor - uses specified service charge
    public ServiceChargeChecking(String accountNumber, String accountHolderName,
                                 String idNumber, double balance, double serviceCharge) {
        super(accountNumber, accountHolderName, idNumber, balance);
        _serviceCharge = serviceCharge;
    }

    // Subtracts service charge from balance
    @Override
    public void monthlyManagement() throws IllegalBalance {
        subtractBalance(_serviceCharge);
    }

    // Getters and setters
    public double getServiceCharge() {
        return _serviceCharge;
    }

    public void setServiceCharge(double _serviceCharge) {
        this._serviceCharge = _serviceCharge;
    }

    // Returns account details as a string
    @Override
    public String toString() {
        return super.toString() + "\nService Charge: " + _serviceCharge;
    }

    // Checks if two accounts are equal
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ServiceChargeChecking)) return false;
        if (!super.equals(obj)) return false;
        ServiceChargeChecking other = (ServiceChargeChecking) obj;
        return _serviceCharge == other._serviceCharge;
    }
}
