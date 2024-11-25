/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmunifiedpatterns;

/**
 *
 * @author stcdo
 */
public class AccountObserver implements Observer {
    private String observerName;
    private ATMView view;

    public AccountObserver(String observerName, ATMView view) {
        this.observerName = observerName;
        this.view = view;
    }

    @Override
    public void update(double balance) {
        
        view.showMessage(observerName + " notified: Balance updated to $" + balance);
    }
}