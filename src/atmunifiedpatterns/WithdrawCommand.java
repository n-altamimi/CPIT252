package atmunifiedpatterns;

public class WithdrawCommand implements ATMCommand {
    @Override
    public void execute(Account account, double amount) {
        // Call the withdraw method on the account (Checking/Savings)
        account.withdraw(amount);
    }
}

