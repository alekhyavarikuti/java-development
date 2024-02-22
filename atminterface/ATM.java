package topperworld.atminterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ATM {
    private static final Map<Integer, Account> bank = new HashMap<>();

    // initialize bank102
    static {

        Account account1 = new Account("100", "Rama", 10000, 1234);
        Account account2 = new Account("101", "Sita", 50000, 5678);
        Account account3 = new Account("102", "Ravi", 70000, 2453);
        Account account4 = new Account("103", "Latha", 30000, 8950);
        bank.put(100, account1);
        bank.put(101, account2);
        bank.put(102, account3);
        bank.put(103, account4);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to ATM ... ");
        System.out.println("Enter your Account Number ... ");
        Scanner sc = new Scanner(System.in);
        int accountNumber = sc.nextInt();
        Account userAccount = bank.get(accountNumber);
        if (userAccount != null) {
            System.out.println("Enter your ATM pin ... ");
            int pin = sc.nextInt();
            if (pin != userAccount.getAtmPin()) {
                System.out.println("wrong pin, you are not authorised to use this account ... ");
            } else {
                while (true) {

                    System.out.println("Select 1 for Withdraw");
                    System.out.println("Select 2 for Deposit");
                    System.out.println("Select 3 for Check Balance");
                    System.out.println("Select 4 for EXIT");
                    System.out.print("Select the appropriate options you want to perform:");
//get the user selected option
                    int op = sc.nextInt();
                    switch (op) {
                        case 1:
                            System.out.print("Enter the amount to be withdrawn :");
// accept the withdraw amount from the user
                            int withdrawAmount = sc.nextInt();
//check whether the balance is greater than or equal to the withdrawal amount
                            withdraw(userAccount, withdrawAmount);
                            break;
                        case 2:
                            System.out.print("Enter the amount to be deposited :");
//accept the deposit amount from the user
                            int depositAmount = sc.nextInt();
// call the function and add the deposit amount to the total balance
                            deposit(userAccount, depositAmount);
                            break;
                        case 3:
// printing the total balance of the user
                            printBalance(userAccount.getBalance());
                            System.out.println(" ");
                            break;
                        case 4:
// exit from the menu
                            System.exit(0);
                    }
                }

            }
        } else {
            System.out.println("Invalid account number ... ");
        }

    }

    // function to print the current balance in an account
    public static void printBalance(int balance) {
        System.out.println(" The Current Balance : " + balance);
        System.out.println();
    }

    // The function to Withdraw an amount and update the balance
    public static int withdraw(Account userAccount, int withdrawAmount) {
        System.out.println("Withdrawn Operation :");
        System.out.println("The withdrawing Amount is : " + withdrawAmount);
        int currentBalance = userAccount.getBalance();
        if (currentBalance >= withdrawAmount) {
            userAccount.setBalance(currentBalance - withdrawAmount);
            System.out.println("Please collect your money and remove the card");
            printBalance(userAccount.getBalance());
        } else {
            System.out.println("Sorry! the balanace is insufficient.");
            System.out.println();
        }
        return userAccount.getBalance();
    }

    // The function to deposit an amount and update the balance
    public static int deposit(Account userAccount, int depositAmount) {
        System.out.println("Deposit Operation :");
        System.out.println(" The depositing amount is : " + depositAmount);
        int currentBalance = userAccount.getBalance();
        userAccount.setBalance(currentBalance + depositAmount);
        System.out.println("Your Money has been successfully deposited");
        printBalance(userAccount.getBalance());
        return userAccount.getBalance();
    }
}