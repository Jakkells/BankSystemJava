import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Account[] accounts = new Account[10];
        int numAccounts = 0;

        int choice;


        do {
            choice = menu(input);
            System.out.println();

            switch (choice) {
                case 1 -> accounts[numAccounts++] = createAccount(input);
                case 2 -> doDeposit(accounts, numAccounts, input);
                case 3 -> doWithdraw(accounts, numAccounts, input);
                case 4 -> applyInterest(accounts, numAccounts, input);
                default -> System.out.println("Goodbye");
            }


            System.out.println();

        }while (choice != 5);



    }

    public static int accountMenu(Scanner input){
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. savings Account");

        int choice;

        do {
            System.out.println("Please enter account type choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 2);
            return choice;


    }

    public static int searchAccount(Account[] accounts, int count, int accountNumber){

        for (int i = 0; i < count; i++){
            if (accounts[i].getAccountNumber() == accountNumber){
                return i;
            }
        }

        return -1;
    }


    public static void doDeposit(Account[] accounts, int count, Scanner input){
        System.out.println("Please enter account number");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0){

            System.out.println("please enter Deposit amount: ");
            double amount = input.nextDouble();

            accounts[index].deposit(amount);

        }else {
            System.out.println("Account is not found");
        }

    }

    public static void doWithdraw(Account[] accounts, int count, Scanner input){
        System.out.println("Please enter account number");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0){

            System.out.println("please enter withdrawal amount: ");
            double amount = input.nextDouble();

            accounts[index].withdraw(amount);

        }else {
            System.out.println("Account is not found");
        }

    }

    public static void applyInterest(Account[] accounts, int count, Scanner input){
        System.out.println("Please enter account number");
        int accountNumber = input.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0){
            if(accounts[index] instanceof SavingsAccount){
                ((SavingsAccount) accounts[index]).applyInterest();
            }

        }else {
            System.out.println("Account is not found");
        }

    }

    public static Account createAccount(Scanner input){
        int choice = accountMenu(input);

        Account account;

        int accountNumber;
        System.out.println("please enter you account number: ");
        accountNumber = input.nextInt();

        if (choice == 1){
            System.out.println("Please enter transaction fee: ");
            double fee = input.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.println("Please enter the interest rate: ");
            double interestRate = input.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);

        }
        return account;
    }

    public static int menu(Scanner input){
        System.out.println("Bank Account Menu");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw funds");
        System.out.println("4. Apply interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.println("Please enter choice: ");
            choice = input.nextInt();

        }while(choice < 1 || choice > 5);
            return choice;


    }

}