/**
 * Account is the super class to create a savings, checking, or loan account.
 * @see <a href="SavingsAccount.html#section">SavingsAccount</a>
 * @see <a href="CheckingAccount.html#section">CheckingAccount</a>
 * @see <a href="LoanAccount.html#section">LoanAccount</a>
 */
public class Account
{
    /** Adding test for codeQL workflow */
    /** The balance of the specific account */
    private double balance;                 // checkings, savings, and loan accounts all have balance variables
    /** The account number of the specific account */
    private String accountNumber;       // The account number created by user for the specific account being created
    /** The specific account holders name */
    private String accountHolder;       // The name of the person with the specific bank accounts


    /**
     * Default constructor so arrayLists can be created for each different account type
     */
    public Account(){} // This needs to be here for the usage of List<> to create arrayLists.

    /**
     * 3 argument constructor to create an account with a specific name, account number, and account holder name
     * @param balance           The input balance from user
     * @param accountNumber     The input account number from user
     * @param accountHolder     The input account holder name from user
     */
    public Account(double balance,String accountNumber, String accountHolder)
    {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    /**
     * A method to return the balance of a specific account.
     * @return          the balance of the specific account
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * A method to deposit a specific amount into an account
     * @param amount        the amount to deposit
     */
    public void deposit(double amount)
    {
        balance += amount;
    }

    /**
     * A method to withdraw a specific number from an account.
     * @param amount        The amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance -= amount;
    }

    /**
     * A method that returns the account holders name
     * @return          The account holders name
     */
    public String getAccountHolder()
    {
        return accountHolder;
    }

    /**
     * Method to add interest for specific accounts and is overridden in specific subclasses.
     */
    public void addInterest() // Method is empty so that only loan and savings accounts can use it.
    {}

    /**
     * Method to print if the account over drafted; Specific to checking accounts.
     */
    public void printOverDraft() // empty because it's only usage is for checking accounts
    {}

    /**
     * Method to make a payment to an account;  Specific to loan accounts.
     * @param payment           The amount to pay
     */
    public void makePayment(double payment) // empty because it's only usage is for loan accounts
    {}

    /**
     * Overriding toString() method to format account information.
     * @return          Formatted string of account information.
     */
    @Override
    public String toString() // overriding toString() method to format a bank accounts information.
    {
        return String.format("Account Holder: %s\n" + "Account Number: %s\n" + "Account Balance: %.2f\n" + "---------------------------------\n",accountHolder,accountNumber,balance);
    }



}
