package atmunifiedpatterns;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements BankServer, Subject {
    protected double balance;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void deposit(double amount) {
        balance += amount;
        notifyObservers();
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        notifyObservers();
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(balance);
        }
    }
}