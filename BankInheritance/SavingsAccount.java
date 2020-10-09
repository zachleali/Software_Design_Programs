/**
 * Subclass of the Account class that creates a savings account object with super class Account.
 * @see <a href="CheckingAccount.html#section">CheckingAccount</a>
 * @see <a href="LoanAccount.html#section">LoanAccount</a>
 * @see <a href="Account.html#section">Account</a>
 */
public class SavingsAccount extends Account
{
    /** static final variable that holds the interest rate for savings accounts. */
    private static final double interest = 0.03; // interest rate for savings accounts


    /**
     * SavingsAccount constructor that calls Accounts 3 argument constructor
     * @param balance           The input balance from user
     * @param accountNumber     The input account number from user
     * @param accountHolder     The input account holder name from user
     */
    public SavingsAccount(double balance,String accountNumber,String accountHolder)
    {
        super(balance,accountNumber,accountHolder);
    }


    /**
     * Overridden method from Account class that adds interest to the savings account.
     */
    @Override
    public void addInterest() // overridden method from Account class for adding interest.
    {
        double addAmount = super.getBalance()*interest;
        super.deposit(addAmount);
    }
}
