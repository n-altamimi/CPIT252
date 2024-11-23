package atmunifiedpatterns;

public class DepositCommand implements ATMCommand {
    @Override
    public void execute(Account account, double amount) {
        // Call the deposit method on the account (Checking/Savings)
        account.deposit(amount);
    }
}