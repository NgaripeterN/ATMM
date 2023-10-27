package atm;

import java.util.Scanner;

class ATM {
    private double balance;

    // Constructor to initialize the balance
    public ATM(double initialBalance) {
        balance = initialBalance;
    }

    // Get the balance
    public void getBalance() {
        System.out.println("The balance is\t" + balance);
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
        getBalance();
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            getBalance();
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}


