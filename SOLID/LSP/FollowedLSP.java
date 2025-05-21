

import java.util.ArrayList;
import java.util.List;

interface DepositOnly{
    void deposit(double balance);
}
interface Withdrawable extends DepositOnly{
    void withdraw(double balance);
}
class SavingsAccount implements Withdrawable{
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
class FixedDepositAccount implements DepositOnly{
    private double balance;
   public FixedDepositAccount(){
        balance=0;
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited "+amount+" in Savings account");
    }
}
class BankClient{
    private List<Withdrawable>withdrawableAccounts;
    private List<DepositOnly>depositOnlyAccounts;
    public BankClient(List<Withdrawable> withdrawableAccounts,
                      List<DepositOnly> depositOnlyAccounts) {
        this.withdrawableAccounts = withdrawableAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (Withdrawable acc : withdrawableAccounts) {
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for (DepositOnly acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }
}
public class FollowedLSP {
    public static void main(String[] args) {
    List<Withdrawable> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingsAccount());

        List<DepositOnly> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedDepositAccount());

        BankClient client = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();

    }

    
}
