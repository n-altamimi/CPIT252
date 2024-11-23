package atmunifiedpatterns;

public interface BankServer {
    void withdraw(double amount);
    void deposit(double amount);
    double getBalance();
}
