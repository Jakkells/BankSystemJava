public class CheckingAccount extends Account{

    private static double Fee = 2.5;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        Fee = fee;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
          balance += amount;
          balance -= Fee;
            System.out.println("You have successfully deposited " + amount + " balance is now " + balance);
        } else {
            System.out.println("a Negative amount can not be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0) {
            if (balance >= amount + Fee){
                balance -= (amount + Fee);
                System.out.println("You have withdrawn " + amount + " your balance is " + balance);
            }else {
                System.out.println("Sorry you do not have enough funds to withdraw");
            }
        } else {
            System.out.println("please withdraw a positive amount");
        }

    }
}
