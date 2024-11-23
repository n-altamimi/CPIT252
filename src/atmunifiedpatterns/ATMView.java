package atmunifiedpatterns;

public class ATMView {
    public void showBalance(double balance) {
        System.out.println("Current Balance: $" + balance);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
