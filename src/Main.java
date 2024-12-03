import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration(10, 55, 70, 50);

        configuration.saveConfig(configuration);
        configuration.loadConfig();

        Vendor vendor1 = new Vendor("1234", 5, 50);
        Thread vendorThread = new Thread(vendor1, "vendor");
        vendorThread.start();

        Customer customer1 = new Customer("4321", 12);
        Thread customerThread = new Thread(customer1, "customer");
        customerThread.start();
    }
}