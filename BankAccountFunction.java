public class BankAccountFunction {
    private double balance;

    public BankAccountFunction() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }
}
