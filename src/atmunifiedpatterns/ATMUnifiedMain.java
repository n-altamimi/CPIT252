package atmunifiedpatterns;

import java.util.Scanner;




import java.util.Scanner;

public class ATMUnifiedMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMView view = new ATMView(); // Initialize ATMView

        while (true) { // Infinite loop to allow restarting
            AccountFactory accountFactory = null;
            Account userAccount = null;

            view.showMessage("Welcome to the ATM System!");

            // Step 1: User selects account type
            view.showMessage("Select account type:");
            view.showMessage("1. Checking Account");
            view.showMessage("2. Savings Account");
            int accountChoice = scanner.nextInt();

            if (accountChoice == 1) {
                accountFactory = new ConcreteCheckingAccount();
            } else if (accountChoice == 2) {
                accountFactory = new ConcreteSavingsAccount();
            } else {
                view.showMessage("Invalid choice. Please try again.");
                continue; // Restart the loop
            }

            userAccount = accountFactory.createAccount();

            // Add observers to the account
            AccountObserver mobileAppObserver = new AccountObserver("MobileApp", view);
            AccountObserver emailAlertObserver = new AccountObserver("EmailAlert", view);

            userAccount.registerObserver(mobileAppObserver);
            userAccount.registerObserver(emailAlertObserver);

            // Step 2: User enters initial balance and PIN
            view.showMessage("Enter a 4-digit PIN:");
            String pin = scanner.next();
            ATM atmProxy = new ATM(userAccount); // ATM proxy initialized with the user's account
            atmProxy.authenticate(pin);

            if (!atmProxy.isAuthenticated()) {
                view.showMessage("Authentication failed! Please try again.");
                continue; // Restart the loop
            }

            view.showMessage("Enter initial balance:");
            double initialBalance = scanner.nextDouble();
            userAccount.deposit(initialBalance);

            ATMController atmController = new ATMController(userAccount, view);

            // Step 3: Display menu and process transactions
            boolean running = true;
            while (running) {
                view.showMessage("\nMenu:");
                view.showMessage("1. Deposit");
                view.showMessage("2. Withdraw");
                view.showMessage("3. Check Balance");
                view.showMessage("4. Apply Interest (Savings Account only)");
                view.showMessage("5. Exit\n");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1: // Deposit
                        view.showMessage("Enter deposit amount:");
                        double depositAmount = scanner.nextDouble();
                        atmController.deposit(depositAmount);
                        break;

                    case 2: // Withdraw
                        view.showMessage("Enter withdrawal amount:");
                        double withdrawAmount = scanner.nextDouble();
                        atmController.withdraw(withdrawAmount);
                        break;

                    case 3: // Check Balance
                        atmController.updateView();
                        break;

                    case 4: // Apply Interest (Savings Account only)
                        if (userAccount instanceof SavingsAccount) {
                            ((SavingsAccount) userAccount).applyInterest();
                            atmController.updateView();
                        } else {
                            view.showMessage("Interest can only be applied to Savings Accounts!");
                        }
                        break;

                    case 5: // Exit
                        view.showMessage("Thank you for using the ATM System!");
                        running = false;
                        break;

                    default:
                        view.showMessage("Invalid option. Try again.");
                }
            }

            view.showMessage("Would you like to restart the program? (yes/no):");
            String restartChoice = scanner.next();
            if (!restartChoice.equalsIgnoreCase("yes")) {
                break; // Exit the loop and end the program
            }
        }

        scanner.close();
    }
}
