import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int totTickets = totalTickets();
        int ticketRelRate = ticketReleaseRate();
        int cusRetRate = customerRetrievalRate();
        int maxTicketCap = maxTicketCapacity();

        //System.out.println(totTickets);
        //System.out.println(ticketRelRate);
        //System.out.println(cusRetRate);
        //System.out.println(maxTicketCap);

        Configuration configuration = new Configuration(totTickets, ticketRelRate, cusRetRate, maxTicketCap);

        configuration.saveConfig(configuration);
        configuration.loadConfig();

        TicketPool ticketPool1 = new TicketPool(configuration.getMaxTicketCapacity());

        Vendor vendor1 = new Vendor("1234", configuration.getTotalTickets(), configuration.getTicketReleaseRate(), ticketPool1);
        Thread vendorThread = new Thread(vendor1, "vendor");
        vendorThread.start();

        Customer customer1 = new Customer("4321", configuration.getCustomerRetrievalRate(), ticketPool1);
        Thread customerThread = new Thread(customer1, "customer");
        customerThread.start();
    }

    public static int totalTickets(){
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter Total Number of Tickets: ");
        return input1.nextInt();
    }


    public static int ticketReleaseRate(){
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter Ticket Release Rate: ");
        return input2.nextInt();
    }

    public static int customerRetrievalRate(){
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter Customer Retrieval Rate: ");
        return input3.nextInt();

    }

    public static int maxTicketCapacity(){
        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter Maximum Ticket Capacity: ");
        return input4.nextInt();
    }

}