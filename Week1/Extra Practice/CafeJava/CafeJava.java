package Java_Fundamentals.PRACTICE.CafeJava;

public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app
        String generalGreeting = "Welcome to Cafe Java,";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $ ";


        // Menu variables (add yours below)//
        double mochaPrice = 3.50;
        double dripPrice = 2.00;
        double lattePrice = 3.00;
        double cappucinoPrice = 3.50;

        // Customer name variables (add yours below)//
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)//
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        // APP INTERACTION SIMULATION (Add your code for the challenges below)//
        // Example://
        System.out.println(generalGreeting+" "+customer1+". ");
        // Displays "Welcome to Cafe Java, Cindhuri"
        //** Your customer interaction print statements will go here **//


        // Cindhuri's order
        // System.out.println(customer1+readyMessage);

        if (isReadyOrder1) {
            System.out.println(customer1+readyMessage+".");
        }
        else {
            System.out.println(customer1+pendingMessage+".");
        }


        // Noah's order
        System.out.println(generalGreeting+" "+customer4+"!");
        if (isReadyOrder4) {
            System.out.println(customer4+readyMessage+".");
        }
        else {
            System.out.println(customer4+pendingMessage+".");
        }
        System.out.printf(displayTotalMessage);
        System.out.printf("%.2f", cappucinoPrice);


        // Sam's order
        System.out.println(". "+generalGreeting+" "+customer2+"!");
        double y = 2.00;
        double newTotal2 = lattePrice * y;

        // System.out.println(displayTotalMessage+newTotal2+".");
        // Output => Your total is $6.0.

        System.out.printf(displayTotalMessage);
        System.out.printf("%.2f", newTotal2);

        // Output => Your total is $6.00. Sam, your order will be ready shortly.

        if (isReadyOrder2) {
            System.out.println(". "+customer2+readyMessage+".");
        }
        else {
            System.out.println(". "+customer2+pendingMessage+".");
        }


        // Jimmy's order
        System.out.println(generalGreeting+" "+customer3+"!");

        // wrong order total
        // System.out.printf(displayTotalMessage);
        // System.out.printf("%.2f", dripPrice);

        double storeCredit = lattePrice - dripPrice;
        String newDisplayTotal = "Your new total is $";
        System.out.printf(newDisplayTotal);
        System.out.printf("%.2f", storeCredit);
    }

}
// https://alvinalexander.com/programming/printf-format-cheat-sheet/
