package bcs;
import java.util.Scanner;
class BankAccount 
{
    private double bal;

    public BankAccount(double initialBalance)
    {
        this.bal = initialBalance;
    }

    public double getBalance() 
    {
        return bal;
    }

    public void deposit(double amount) 
    {
        bal += amount;
    }

    public boolean withdraw(double amount)
    {
        if (amount <= bal)
        {
            bal -= amount;
            return true;
        }
        else
        {
            return false;
        }
    }
}

class bank 
{
    private BankAccount userAcc;

    public bank(BankAccount account)
    {
        this.userAcc = account;
    }

    public void displayOptions() 
    {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeOption(int Option, Scanner scanner)
    {
        switch (Option)
        {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAcc.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + userAcc.getBalance());
                }
                else
                {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAcc.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: " + userAcc.getBalance());
                break;
            case 3:
                System.out.println("Current balance: " + userAcc.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class Main 
{

	public static void main(String[] args)
	{
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter initial balance: ");
	        double initialBalance = sc.nextDouble();

	        BankAccount userAccount = new BankAccount(initialBalance);
	        bank atm = new bank(userAccount);

	        while (true) {
	            atm.displayOptions();
	            System.out.print("Choose an option (1-4): ");
	            int option = sc.nextInt();

	            atm.executeOption(option, sc);
	        }
	    }	
	}
