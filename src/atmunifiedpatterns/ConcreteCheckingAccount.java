package atmunifiedpatterns;

public class ConcreteCheckingAccount implements AccountFactory {
    @Override
    public Account createAccount() {
        return new CheckingAccount();
    }
}
