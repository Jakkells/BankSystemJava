public class SavingsAccount extends Account {

    private double InterestRate;

    public SavingsAccount (){
        super();
    }

    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        InterestRate = interestRate;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    public double calculateInterestRate(){
        return balance * InterestRate;
    }

    public void applyInterest(){
        double interest = calculateInterestRate();
        System.out.println("Interest accured is " + interest + " this is added to balance");
        deposit(calculateInterestRate());
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
            System.out.println("You have successfully deposited " + amount + " balance is now " + balance);
        } else {
            System.out.println("a Negative amount can not be deposited");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0) {
            if (balance >= amount){
                balance -= (amount);
                System.out.println("You have withdrawn " + amount + " your balance is " + balance);
            }else {
                System.out.println("Sorry you do not have enough funds to withdraw");
            }
        } else {
            System.out.println("please withdraw a positive amount");
        }

    }


}
