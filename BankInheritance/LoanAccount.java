/**
 * Subclass of the Account class that creates a loan account object with super class Account.
 * @author Zach Leali
 * @see <a href="SavingsAccount.html#section">SavingsAccount</a>
 * @see <a href="CheckingAccount.html#section">CheckingAccount</a>
 * @see <a href="Account.html#section">Account</a>
 */
public class LoanAccount extends Account
{
    /** static final variable that holds the interest rate for loan accounts. */
    private static final double interestRate = 0.02; // interest rate for loan accounts

    /**
     * LoanAccount constructor that calls Accounts 3 argument constructor
     * @param balance           The input balance from user
     * @param accountNumber     The input account number from user
     * @param accountHolder     The input account holder name from user
     */
    LoanAccount(double balance, String accountNumber, String accountHolder)
    {
        super(balance,accountNumber,accountHolder);
    }

    /**
     * Method to add interest to loan account with loan account interest rate
     */
    @Override
    public void addInterest() // overridden method from Account to add loan interest to loan account
    {
        double addAmount = super.getBalance()*interestRate;
        super.deposit(addAmount);
    }

    /**
     * Method to make a payment on a loan account
     * @param payment           The amount to pay
     */
    @Override
    public void makePayment(double payment) // overridden method from Account to make loan payments on the account
    {
        super.withdraw(payment);
    }
}
