import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(10, 55, 70, 50);

        configuration.saveConfig(configuration);
        configuration.loadConfig();

        TicketPool ticketPool1 = new TicketPool(50);

        Vendor vendor1 = new Vendor("1234", 5, 50, ticketPool1);
        Thread vendorThread = new Thread(vendor1, "vendor");
        vendorThread.start();

        Customer customer1 = new Customer("4321", 3, ticketPool1);
        Thread customerThread = new Thread(customer1, "customer");
        customerThread.start();
    }
}