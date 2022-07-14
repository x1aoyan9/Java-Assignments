public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        System.out.println("New Acc No. - " + acc1.getAccId());
        acc1.deposit(200.0, "checking");
        acc1.deposit(150.0, "savings");
        acc1.displayAccountBalance();

        // Must debug withdraw() method
        acc1.withdraw(50.0, "checking");
        acc1.withdraw(50.0, "savings");
        acc1.displayAccountBalance();
        
        BankAccount acc2 = new BankAccount();
        System.out.println("New Acc No. - " + acc2.getAccId());
        acc2.deposit(350.0, "checking");
        acc2.deposit(200.0, "savings");
        acc2.displayAccountBalance();

        // Must debug withdraw() method
        acc2.withdraw(400.0, "checking");
        acc2.withdraw(250.0, "savings");
        acc2.displayAccountBalance();

        System.out.println("Total open accounts = " + BankAccount.countAccounts());
        System.out.println("Total bank wealth = " + BankAccount.total());
    }
}