package atmunifiedpatterns;


public interface ATMCommand {
    void execute(Account account, double amount);
}