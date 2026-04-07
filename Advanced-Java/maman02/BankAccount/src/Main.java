/**BankAccount.
 * @author Emanuel Abraham
 * @version 07/04/2026 (2026b)
 */

public class Main {
    public static void main (String[]args){

        // Create an array of 5 bank accounts of different types
        BankAccount[] accounts = new BankAccount[5];
        accounts[0] = new ServiceChargeChecking("1", "user1", "11111", 100);
        accounts[1] = new NoServiceChargeChecking("2", "user2", "22222", 100);
        accounts[2] = new InterestChecking("3", "user3", "33333", 100);
        accounts[3] = new SavingsAccount("4", "user4", "44444", 100);
        accounts[4] = new HighInterestSavings("5", "user5", "55555", 100);

        // Print the details of all accounts
        System.out.println("--- Initial Account Status ---\n");
        for (int i=0; i<accounts.length; i++){
            System.out.println("Account Type: " + accounts[i].getClass().getSimpleName());
            System.out.println(accounts[i]);
            System.out.println("-----------------------------");
        }


        // Change the monthly service charge for user1
        System.out.println("\n--- Changing user1 serviceCharge ---");
        ((ServiceChargeChecking) accounts[0]).setServiceCharge(40);
        System.out.println("New Service Charge: " + ((ServiceChargeChecking) accounts[0]).getServiceCharge());
        System.out.println("\n" + accounts[0]);
        System.out.println("\n-----------------------------");


        // Change the minimum balance for user2, then try to withdraw more than allowed
        System.out.println("\n--- Changing user2 Minimum Balance ---");
        ((NoServiceChargeChecking) accounts[1]).setMinimumBalance(1000);
        System.out.println("New Minimum Balance: " + ((NoServiceChargeChecking) accounts[1]).getMinimumBalance());
        System.out.println("\n--- Attempting to withdraw funds exceeding the account balance ---");
        try {
            accounts[1].subtractBalance(1500);
        } catch (IllegalBalance e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n" + accounts[1]);
        System.out.println("\n-----------------------------");


        // Change the interest rate for user3
        System.out.println("\n--- Changing user3 Interest Rate ---");
        ((InterestChecking) accounts[2]).setInterestRate(0.03);
        System.out.println("New Interest Rate: " + ((InterestChecking) accounts[2]).getInterestRate());
        System.out.println("\n" + accounts[2]);
        System.out.println("\n-----------------------------");


        // Change the interest rate for user4
        System.out.println("\n--- Changing user4 Interest Rate ---");
        ((SavingsAccount) accounts[3]).setInterestRate(0.05);
        System.out.println("New Interest Rate: " + ((SavingsAccount) accounts[3]).getInterestRate());
        System.out.println("\n" + accounts[3]);
        System.out.println("\n-----------------------------");


        // Try to withdraw more than allowed from user5 (below minimum balance)
        System.out.println("\n--- user5: Attempting to withdraw funds exceeding the account balance ---");
        try {
            accounts[4].subtractBalance(450);
        } catch (IllegalBalance e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n" + accounts[4]);
        System.out.println("\n-----------------------------");


        // Print the monthly management for all accounts
        System.out.println("\n--- Monthly Management ---");
        for (BankAccount account : accounts) {
            try {
                account.monthlyManagement();
                System.out.println("Monthly management done for: " + account.getAccountNumber());
                System.out.println(account);
                System.out.println("-----------------------------");
            } catch (IllegalBalance e) {
                System.out.println("Error in monthly management for " +
                        account.getAccountNumber() + ": " + e.getMessage());
                System.out.println("-----------------------------");
            }
        }
    }
}