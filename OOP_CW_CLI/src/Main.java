import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        int numVendors;
        int ticketPerRelease;
        int numReleases;
        int numCustomer;
        int ticketsPerCustomer;

        System.out.println("Configuration Form");
        int totTickets = intInput("Enter Total Number of Tickets: ");
        int ticketRelRate = intInput("Enter Ticket Release Rate: ");
        int cusRetRate = intInput("Enter Customer Retrieval Rate: ");
        int maxTicketCap = intInput("Enter Maximum Ticket Capacity: ");

        System.out.println("------------");
        System.out.println("For Simulate:-");
        System.out.println("Note - Enter value that (Number of customer)*(Buying ticket per customer) = (Total tickets) to smooth simulation for the system");

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
        System.out.println("------------");

        while (true){
            String start = stringInput("Start System? (Yes/No): ");

            if(start.equals("yes") || start.equals("Yes")){
                Configuration configuration = new Configuration(totTickets, ticketRelRate, cusRetRate, maxTicketCap);

                configuration.saveConfig(configuration);
                configuration.loadConfig();

                TicketPool ticketPool1 = new TicketPool(configuration.getMaxTicketCapacity());

                Vendor[] vendors = new Vendor[numVendors];
                Thread vendorThread = null;

                System.out.println(vendors.length);
                for(int i = 0; i < vendors.length; i++){
                    vendors[i] = new Vendor("0"+i, ticketPerRelease, configuration.getTicketReleaseRate(), ticketPool1, numVendors, numReleases, configuration.getTotalTickets());
                    vendorThread = new Thread(vendors[i], "vendor");
                    vendorThread.start();
                }

                Customer[] customers = new Customer[numCustomer];
                Thread customerThread = null;
                for(int j = 0; j < customers.length; j++){
                    Customer customer1 = new Customer("0"+j, configuration.getCustomerRetrievalRate(), ticketPool1, numCustomer, ticketsPerCustomer);
                    customerThread = new Thread(customer1, "customer");
                    customerThread.start();
                }

                if(vendors.length != 0 || customers.length != 0){
                    try {
                        customerThread.join();
                        vendorThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
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

    public static int intInput(String message){
        while (true){
            try {
                Scanner input1 = new Scanner(System.in);
                System.out.print(message);
                return input1.nextInt();
            }catch (InputMismatchException e){
                logger.warn(e + " - Please enter Integer value!");
            }
        }
    }

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