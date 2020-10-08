import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S42_BankInheritance_Easy_Driver
{
    public static void main(String[] args)
    {
        List<Account> checkingAccounts = new ArrayList<>(); // container for all created checking accounts
        List<Account> savingsAccounts = new ArrayList<>(); // container for all created savings accounts
        List<Account> loanAccounts = new ArrayList<>(); // container for all created loan accounts
        boolean bankingSystem = true;

        while(bankingSystem)
        {
            Scanner getInput = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("(Press 1 to create Checking Account)");
            System.out.println("(Press 2 to create Savings Account)");
            System.out.println("(Press 3 to create Loan Account)");

            System.out.println("(Press 4 to see a list of checking accounts)");
            System.out.println("(Press 5 to see a list of savings accounts)");
            System.out.println("(Press 6 to see a list of loan accounts)");

            System.out.println("(Press 7 to make a deposit checking account)");
            System.out.println("(Press 8 to make a withdrawal from checking account)");

            System.out.println("(Press 9 to add interest to a savings account)");
            System.out.println("(Press 10 to make a withdrawal from savings account)");
            System.out.println("(Press 11 to make a deposit savings account)");

            System.out.println("(Press 12 to make a payment on a loan account)");
            System.out.println("(Press 13 to add interest to loan account)");

            System.out.println("(Press 0 to exit)");
            String answer = getInput.nextLine();

            if(answer.equals("1")) // creating checking accounts
            {
                String name;
                String accountNum;
                double amount;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter Account Holder Name: ");
                name = input.nextLine().toLowerCase();
                System.out.print("Enter Account Number: ");
                accountNum = input.nextLine();
                System.out.print("Enter Balance: ");
                amount = Double.parseDouble(input.nextLine());
                checkingAccounts.add(new CheckingAccount(amount, accountNum, name));

            }

            if(answer.equals("2")) // creating savings accounts
            {
                String name;
                String accountNum;
                double amount = 0;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter Account Holder Name: ");
                name = input.nextLine().toLowerCase();
                System.out.print("Enter Account Number: ");
                accountNum = input.nextLine();
                System.out.print("Enter Balance: ");
                amount = input.nextDouble();
                savingsAccounts.add(new SavingsAccount(amount,accountNum,name));
            }

            if(answer.equals("3")) // creating loan accounts
            {
                String name;
                String accountNum;
                double amount = 0;
                Scanner input = new Scanner(System.in);
                System.out.print("Enter Account Holder Name: ");
                name = input.nextLine().toLowerCase();
                System.out.print("Enter Account Number: ");
                accountNum = input.nextLine();
                System.out.print("Enter Balance: ");
                amount = input.nextDouble();
                loanAccounts.add(new LoanAccount(amount,accountNum,name));
            }

            if(answer.equals("4")) // prints out all created checking accounts
            {
                System.out.println("Checking Accounts: ");
                for(Account list : checkingAccounts)
                {
                    System.out.println(list);
                }
            }

            if(answer.equals("5")) // prints out all created savings accounts
            {
                System.out.println("Savings Accounts: ");
                for(Account list : savingsAccounts)
                {
                    System.out.println(list);
                }
            }

            if(answer.equals("6")) // prints out all created loan accounts
            {
                System.out.println("Loan Accounts: ");
                for(Account list : loanAccounts)
                {
                    System.out.println(list);
                }
            }

            if(answer.equals("7")) // make deposit for checking account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to deposit: ");
                String name = in.nextLine().toLowerCase();
                System.out.print("Enter amount to deposit: ");
                double amount = in.nextDouble();
                for(int i = 0; i < checkingAccounts.size(); i++)
                {
                    if(checkingAccounts.get(i).getAccountHolder().equals(name))
                    {
                        checkingAccounts.get(i).deposit(amount);
                    }
                }
            }

            if(answer.equals("8")) // make a withdrawal from checking account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to make a withdrawal from: ");
                String name = in.nextLine().toLowerCase();
                System.out.print("Enter an amount to withdraw: ");
                double amount = in.nextDouble();
                for(int i = 0; i < checkingAccounts.size(); i++)
                {
                    if(checkingAccounts.get(i).getAccountHolder().equals(name))
                    {
                        checkingAccounts.get(i).withdraw(amount);
                        checkingAccounts.get(i).printOverDraft();

                    }
                }
            }

            if(answer.equals("9")) // adding interest to savings account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to add interest to savings account: ");
                String name = in.nextLine().toLowerCase();
                for(int i = 0; i < savingsAccounts.size();i++)
                {
                    if(savingsAccounts.get(i).getAccountHolder().equals(name))
                    {
                        savingsAccounts.get(i).addInterest();
                    }
                }
            }

            if(answer.equals("10")) // withdrawing from savings account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to make a withdrawal from savings account: ");
                String name = in.nextLine().toLowerCase();
                System.out.print("Enter how much to withdraw: ");
                double amount = in.nextDouble();
                for(Account list : savingsAccounts)
                {
                    if(list.getAccountHolder().equals(name))
                    {
                        list.withdraw(amount);
                        if(list.getBalance() < 0)
                        {
                            System.out.println("Can't withdraw that amount.");
                            list.deposit(amount);
                        }
                    }
                }
            }

            if(answer.equals("11")) // deposit into savings account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to deposit into savings: ");
                String name = in.nextLine().toLowerCase();
                System.out.print("Enter amount to deposit: ");
                double amount = in.nextDouble();
                for(Account list : savingsAccounts)
                {
                    if(list.getAccountHolder().equals(name))
                    {
                        list.deposit(amount);
                    }
                }
            }

            if(answer.equals("12")) // making a payment on a loan account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to make a loan payment: ");
                String name = in.nextLine().toLowerCase();
                System.out.print("Enter amount to pay: ");
                double amount = in.nextDouble();
                for(Account list : loanAccounts)
                {
                    if(list.getAccountHolder().equals(name))
                    {
                        list.makePayment(amount);
                    }
                }
            }

            if(answer.equals("13")) // adding interest to loan account
            {
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of account holder to add interest to loan account: ");
                String name = in.nextLine().toLowerCase();
                for(Account list : loanAccounts)
                {
                    if(list.getAccountHolder().equals(name))
                    {
                        list.addInterest();
                    }
                }
            }

            if(answer.equals("0")) // exits
            {
                bankingSystem = false;
            }
        }
    }
}
