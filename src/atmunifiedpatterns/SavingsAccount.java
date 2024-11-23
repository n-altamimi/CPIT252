package atmunifiedpatterns;

public class SavingsAccount extends Account {
    private double interestRate = 0.02; // Example interest rate (2%)

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Applied interest of $" + interest + " to Savings Account.");
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Deposited $" + amount + " into Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account.");
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
