package topperworld.atminterface;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private int balance;
    private int atmPin;

    Account (String accountNumber, String accountHolder, int balance, int atmPin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.atmPin = atmPin;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAtmPin() {
        return this.atmPin;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public void setAtmPin(int newPin) {
        this.atmPin = newPin;
    }
}
