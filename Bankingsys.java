
import java.util.*;

public class Bankingsys {
 
    static class NegativeAmountException extends Exception {
        public NegativeAmountException(String msg) {
            super(msg);
        }
    }

    static class InsufficientBalanceException extends Exception {
        public InsufficientBalanceException(String msg) {
            super(msg);
        }
    }

    static class NetworkException extends Exception {
        public NetworkException(String msg) {
            super(msg);
        }
    }

    static class BankAccount {

        double balance = 5000;

        void withdraw(double amount) throws NegativeAmountException,InsufficientBalanceException,NetworkException {

            if (amount <= 0) {
                throw new NegativeAmountException("Amount cannot be negative!");
            }

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient Balance!");
            }

            if (Math.random() < 0.3) {
                throw new NetworkException("Network Error! Try Again.");
            }

            balance -= amount;
            System.out.println("Withdrawal Successful!");
            System.out.println("Remaining Balance: " + balance);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction Completed.");
        }

        sc.close();
    }
}
