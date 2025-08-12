import java.util.Scanner;

public class BankAccount {
    private final String accountHolder;
    private double balance;



    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    // A method to handle deposit calculations then format it to $00,000.00
    public void deposit(double amount) {
        if (amount > 0 ) {
            balance += amount;
            System.out.printf("Deposited: $%,.2f\n", amount);
        }
    }
    //A method to withdraw calculations then format it to $00,000.00
    public void withdraw (double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.printf("withdraw: $%,.2f\n", amount);
        }else {
            // prevent from going negative
            System.out.println("Insufficient funds!");
        }
    } // method to get user balance
    public double getBalance(){

        return balance;
    }

    // main method that the user can interact with

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your initial balance: ");
        // error handling
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.next();
        }
        double initialBalance = scanner.nextDouble();
        //uses BankAccount method info to
        BankAccount myAccount = new BankAccount(name, initialBalance);
        System.out.printf("Account created for %s with a balance of $%,.2f\n",name, initialBalance);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.printf("Available balance: $%,.2f", myAccount.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using my BankAccount program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }

        scanner.close();



    }


}

