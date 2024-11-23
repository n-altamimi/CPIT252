package atmunifiedpatterns;

public class ConcreteSavingsAccount implements AccountFactory {
    @Override
    public Account createAccount() {
        return new SavingsAccount();
    }
}