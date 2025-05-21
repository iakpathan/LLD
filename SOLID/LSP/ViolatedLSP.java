/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


import java.util.ArrayList;
import java.util.List;
interface Account{
    void deposit(double amount);
    void withdraw(double amount);
}
class SavingsAccount implements Account{
    private double balance;
   public SavingsAccount(){
        balance=0;
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited "+amount+" in Savings account");
    }
    public void withdraw(double amount){
        balance-=amount;
        System.out.println("Widthrawan "+amount+" from Savings account");
    }
}
class FixedDepositAccount implements Account{
    private double balance;
   public FixedDepositAccount(){
        balance=0;
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited "+amount+" in Savings account");
    }
    public void withdraw(double amount){
       throw new UnsupportedOperationException("Widthrawal not allowed in fixed deposit");
    }
}
class BankClient {
    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void process() {
        for (Account acc : accounts) {
            acc.deposit(1000);  // All accounts allow deposits

            // Assuming all accounts support withdrawal (LSP Violation)
            try {
                acc.withdraw(500);
            } catch (UnsupportedOperationException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
public class ViolatedLSP {
   public static void main (String[] args) {
        List<Account>accounts=new ArrayList<>();
    accounts.add(new SavingsAccount());
    accounts.add(new FixedDepositAccount());
    BankClient client=new BankClient(accounts);
    client.process();

    }
   
    
}
