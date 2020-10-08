/**
 * Subclass of the Account class that creates a checking account object with super class Account.
 * @author Zach Leali
 * @see <a href="SavingsAccount.html#section">SavingsAccount</a>
 * @see <a href="LoanAccount.html#section">LoanAccount</a>
 * @see <a href="Account.html#section">Account</a>
 */
public class CheckingAccount extends Account
{
    /** static final variable that is used for printing out information if checking account balance is less that the overDraft */
    private static final double overDraft = -35.00; // the value to compare the balance to so that it prints out when the balance is lower.

    /**
     * CheckingAccount constructor that calls Accounts 3 argument constructor
     * @param balance           The input balance from user
     * @param accountNumber     The input account number from user
     * @param accountHolder     The input account holder name from user
     */
    CheckingAccount(double balance, String accountNumber, String accountHolder)
    {
        super(balance,accountNumber,accountHolder);
    }


    /**
     * Method that lets the user know when a checking account's balance is less than the overDraft variable.
     */
    @Override
    public void printOverDraft() // overriding Account method printOverDraft()
    {
        if(super.getBalance() < overDraft)
        {
            System.out.println("Account for " + super.getAccountHolder() + " has over drafted." + "  Current balance: " + super.getBalance());
        }
    }
}
