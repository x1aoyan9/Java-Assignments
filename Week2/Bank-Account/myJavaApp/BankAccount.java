import java.util.Random;

public class BankAccount {
    // Static variables w static methods
    // private static int accId;
    private static int numOfAccounts = 0;
    private static int totalBank = 0;

    private static int accId(){     // Generates ID per account
        Random randGen = new Random();
        int accId = randGen.nextInt(1000000) + 9999999;
        return accId;
    }

    public static int countAccounts(){      // Counts total number of bank accounts
        return numOfAccounts;
    }

    public static int total(){      // Counts the bank's entire wealth (all accounts added together)
        return totalBank;
    }

    // Non-static variables
    private int AccId;
    private double checking;
    private double saving;

    public BankAccount(){       // Method run when a new account is made
        this.AccId = BankAccount.accId();
        this.checking = 0;
        this.saving = 0;
        numOfAccounts++;
    }

    // GET checking
    public double getCheck(){
        return checking;
    }

    // GET savings
    public double getSave(){
        return saving;
    }

    // GET account number
    public int getAccId(){
        return this.AccId;
    }

    // Substituting for .set() command
    public void deposit(double amount, String account){
        // if(this.AccId != BankAccount.accId)
        //     System.out.println("Inaccessible.");
        if(account.equals("checking")){
            this.checking += amount;
            System.out.println(this.AccId + " depositted $" + amount + " to their checking.");
        }
        else if(account.equals("savings")){
            this.saving += amount;
            System.out.println(this.AccId + " depositted $" + amount + " to their savings.");
        }
        BankAccount.totalBank += amount;
    }

    public void withdraw(double amount, String account){
        boolean successful = false;
        // if(this.AccId != BankAccount.accId)
        //     System.out.println("Inaccessible.");
        if(account.equals("checking")){
            if(this.checking - amount >= 0){        // check if there's enough in the account
                successful = true;
                this.checking -= amount;
                System.out.printf(this.AccId + " withdrew $" + amount + " from their checking. ");
            }
        }
        else if(account.equals("savings")){
            if(this.saving - amount >= 0){        // check if there's enough in the account
                successful = true;
                this.saving -= amount;
                System.out.println(this.AccId + " withdrew $" + amount + " from their savings. ");
            }
        }
        if(successful){
            BankAccount.totalBank -= amount;
        }
        else{
            System.out.println("Sorry, insufficient funds. ");
        }
    }

    public void displayAccountBalance(){
        // %.2f formats decimal to the 10s place
        System.out.println(String.format("Checking: $%.2f, Savings: $%.2f", this.checking, this.saving));
    }
}