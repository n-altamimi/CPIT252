package atmunifiedpatterns;

public class ATM implements BankServer {
    private BankServer bank;
    private boolean isAuthenticated;

    public ATM(BankServer bank) {
        this.bank = bank;
        this.isAuthenticated = false;
    }

    public void authenticate(String pin) {
        isAuthenticated = "1234".equals(pin); //1234 is the correct PIN
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void withdraw(double amount) {
        if (isAuthenticated) {
            bank.withdraw(amount);
        } else {
            System.out.println("Authentication failed!");
        }
    }

    @Override
    public void deposit(double amount) {
        if (isAuthenticated) {
            bank.deposit(amount);
        } else {
            System.out.println("Authentication failed!");
        }
    }

    @Override
    public double getBalance() {
        return isAuthenticated ? bank.getBalance() : -1;
    }
}
