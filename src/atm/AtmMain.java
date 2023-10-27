package atm;

import java.util.Scanner;

public class AtmMain {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ATM myATM = new ATM(1000.0);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int pinAttempts = 0;
        boolean pinIsValid = false;

        while (isRunning && !pinIsValid) {
            System.out.println("Enter your pin:");
            int pin = scanner.nextInt();

            if (pin == 1234) {
                pinIsValid = true;
            } else {
                pinAttempts++;

                if (pinAttempts == 3) {
                    System.out.println("Too many failed PIN attempts. Your card has been blocked.");
                    isRunning = false;
                } else {
                    System.out.println("Incorrect PIN. Please try again.");
                }
            }
        }

        // Added code to move the code that sets the `isRunning` variable to `false` outside of the `while` loop
        if (pinIsValid) {
            while (isRunning) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Make a Deposit");
                System.out.println("3. Make a Withdrawal");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        myATM.getBalance();
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        myATM.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        myATM.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        isRunning = false;
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                }
            }

            scanner.close();
        }
    }
}
