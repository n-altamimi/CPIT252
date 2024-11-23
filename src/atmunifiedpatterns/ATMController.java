package atmunifiedpatterns;


public class ATMController {
    private Account model; // Could be CheckingAccount or SavingsAccount
    private ATMView view;
    private ATMCommand depositCommand;  // Deposit Command instance
    private ATMCommand withdrawCommand; // Withdraw Command instance

    public ATMController(Account model, ATMView view) {
        this.model = model;
        this.view = view;
        this.depositCommand = new DepositCommand(); // Create deposit command
        this.withdrawCommand = new WithdrawCommand(); // Create withdraw command
    }

    public void deposit(double amount) {
        depositCommand.execute(model, amount);  // Execute deposit through the command
        view.showMessage("Deposited $" + amount);
        updateView();
    }

    public void withdraw(double amount) {
        withdrawCommand.execute(model, amount);  // Execute withdraw through the command
        updateView();
    }

    public void updateView() {
        view.showBalance(model.getBalance());
    }
}