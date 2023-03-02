public abstract class Account {

    protected double balance;
    private int accountNumber;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);


}
