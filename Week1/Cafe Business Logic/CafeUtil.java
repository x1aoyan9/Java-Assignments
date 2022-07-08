import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(){
        int drink = 0;  //number of drinks ordered which starts at zero//
        int numWeeks = 10; //the condition meant to tell the loop for how long to run, in this case, 10 times; this can now be independently changed and will change the for loop without needing to rewrite it//
        for(int week = 1; week <= numWeeks; week++){
        //starting week 1 and counting until numWeeks = 10; suns together every consecutive integer from 1 to 10 and returns the sum(of drinks that need to be ordered if you always buy 1 more drink than you had the week prior)//
            drink+= week;  //gets sum of drink + week//
        }
        return drink;  //the number of drinks one would order after 10 weeks//
    }

    public double getOrderTotal(double[]lineItems){
        double sum = 0;  //order begins empty//
        for(double price:lineItems){ //lineItems array is declared on TestCafe//
        //read like: for each double element(called price) in the array lineItems//
            sum+= price; //get total price for order//
        }
        return sum;
    }
    

    public void displayMenu(ArrayList<String>menuItems){
        for(int id = 0; id < menuItems.size(); id++){
            System.out.printf("%s %s \n", id, menuItems.get(id));
        }
    }

    public void addCustomer(ArrayList<String>customerList){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customerList.size());
        customerList.add(userName);
        System.out.println(customerList);
    }

    public void printPriceChart(String menu, double price, int maxQuantity){
        System.out.printf("%s\n", menu);
        for(int quantity = 1; quantity < maxQuantity; quantity++){
            System.out.printf("%s - $.2f\n", quantity, quantity*price);
        }
        System.out.println("");
    }
}
