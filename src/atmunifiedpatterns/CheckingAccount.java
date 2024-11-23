package atmunifiedpatterns;

public class CheckingAccount extends Account {
    private double withdrawLimit = 5000.0; // Example daily limit
    private ATMView view = new ATMView();

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawLimit) {
            view.showMessage("Please visit the nearest branch or withdraw an amount less than $5000.");
        } else if (amount > balance) {
            view.showMessage("Insufficient funds. Please enter an amount less than or equal to your balance.");
        } else {
            balance -= amount;
            view.showMessage("Withdrawal of $" + amount + " successful!");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        view.showMessage("Deposited $" + amount + " into Checking Account.");
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
