package atmunifiedpatterns;

public class Bank implements BankServer {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
