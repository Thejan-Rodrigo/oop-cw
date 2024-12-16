import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        //These variables are use for save user input and passes to the methods
        int numVendors;
        int ticketPerRelease;
        int numReleases;
        int numCustomer;
        int ticketsPerCustomer;
        String eventName;
        int ticketPrice;

        //Get User input for passes to the methods
        System.out.println("Configuration Form");
        int totTickets = intInput("Enter Total Number of Tickets: ");
        int ticketRelRate = intInput("Enter Ticket Release Rate: ");
        int cusRetRate = intInput("Enter Customer Retrieval Rate: ");
        int maxTicketCap = intInput("Enter Maximum Ticket Capacity: ");

        System.out.println("------------");
        System.out.println("For Simulate:-");
        System.out.println("Note - Enter value that (Number of customer)*(Buying ticket per customer) = (Total tickets) to smooth simulation for the system");

        //validate smooth simulation
        while (true){
            numCustomer = intInput("Enter number of Customers: ");
            ticketsPerCustomer = intInput("Enter number of tickets that each customer should buy: ");
            if(numCustomer * ticketsPerCustomer != totTickets){
                System.out.println("Customer should buy all the tickets to end the simulation");
                System.out.println("Enter numbers that equals to the total number of tickets");
            }else {
                break;
            }
        }

        //validate Smooth Simulation
        while (true){
            numVendors = intInput("Enter number of Vendors: ");
            ticketPerRelease = intInput("Enter number of ticket per single release: ");
            numReleases = intInput("Enter number of releases that Vendor make: ");

            if(numVendors * ticketPerRelease * numReleases != totTickets){
                System.out.println("Vendors should add all the tickets to the Ticket Pool ");
                System.out.println("Enter numbers that equals to  the total number of tickets");
            }else {
                break;
            }
        }

        //Get user input for Ticket Class
        eventName = stringInput("Enter Ticket Event Name: ");
        ticketPrice = intInput("Enter Ticket Price: ");
        System.out.println("------------");

        //Make sure to start the system
        while (true){
            String start = stringInput("Start System? (Yes/No): ");

            if(start.equals("yes") || start.equals("Yes")){
                //Create a Configuration Object
                Configuration configuration = new Configuration(totTickets, ticketRelRate, cusRetRate, maxTicketCap);

                //Save all the information in to the
                configuration.saveConfig(configuration);
                configuration.loadConfig();

                //Create a new Ticket Pool
                TicketPool ticketPool1 = new TicketPool(configuration.getMaxTicketCapacity());

                //Create a new list of vendors according to the user in put number of vendors
                Vendor[] vendors = new Vendor[numVendors];
                Thread vendorThread = null;

                //Create a new vendor object and put in the vendor List
                for(int i = 0; i < vendors.length; i++){
                    vendors[i] = new Vendor("0"+i, ticketPerRelease, configuration.getTicketReleaseRate(), ticketPool1, numVendors, numReleases, configuration.getTotalTickets(), eventName, ticketPrice);
                    vendorThread = new Thread(vendors[i], "vendor");
                    vendorThread.start();
                }

                //Create a new list of customers according to the user in put number of customers
                Customer[] customers = new Customer[numCustomer];
                Thread customerThread = null;

                //Create a new customers object and put in the customer List
                for(int j = 0; j < customers.length; j++){
                    Customer customer1 = new Customer("0"+j, configuration.getCustomerRetrievalRate(), ticketPool1, numCustomer, ticketsPerCustomer);
                    customerThread = new Thread(customer1, "customer");
                    customerThread.start();
                }

                //Waiting for all the thread for execute
                if(vendors.length != 0 || customers.length != 0){
                    try {
                        customerThread.join();
                        vendorThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //Stop the program manually
                System.out.println("Simulation End!");
                System.out.println("Exiting System!");
                break;
            } else if (start.equals("no") || start.equals("No")){
                System.out.println("Exiting System!");
                break;
            }
        }
        //System.out.println(totTickets);
        //System.out.println(ticketRelRate);
        //System.out.println(cusRetRate);
        //System.out.println(maxTicketCap);
    }

    //Create a Method for validate user integer inputs
    public static int intInput(String message){
        while (true){
            try {
                Scanner input1 = new Scanner(System.in);
                System.out.print(message);
                int value = input1.nextInt();
                 if(value >0){
                     return value;
                 }else {
                     logger.warn("Please enter Positive Integer value!");
                 }
            }catch (InputMismatchException e){
                logger.warn(e + " - Please enter Integer value!");
            }
        }
    }

    //Create a Method for validate user String inputs
    public static String stringInput(String message){
        while (true){
            try {
                Scanner input2 = new Scanner(System.in);
                System.out.print(message);
                return input2.next();
            }catch (InputMismatchException e){
                logger.warn(e + " - Please enter String value!");
            }
        }
    }
}