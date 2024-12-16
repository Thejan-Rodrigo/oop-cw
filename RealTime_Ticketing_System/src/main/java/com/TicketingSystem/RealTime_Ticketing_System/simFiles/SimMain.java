package com.TicketingSystem.RealTime_Ticketing_System.simFiles;

import com.TicketingSystem.RealTime_Ticketing_System.dto.SimConfigDTO;
import org.apache.log4j.BasicConfigurator;

public class SimMain {

    public static SimTicketPool simTicketPool1;

    public static void setData(SimConfigDTO simConfigDTO){
        BasicConfigurator.configure();
        SimConfiguration configuration = new SimConfiguration(simConfigDTO.getNumTickets(), simConfigDTO.getReleaseRate(), simConfigDTO.getRetrievalRate(), simConfigDTO.getTicketCapacity());
        System.out.println("Configuration Done");
        configuration.saveConfig(configuration);
        configuration.loadConfig();
        System.out.println("Configuration Save");

        simTicketPool1 = new SimTicketPool(configuration.getMaxTicketCapacity(), configuration.getTotalTickets());
        System.out.println("TicketPool Done");
        SimVendor[] vendors = new SimVendor[simConfigDTO.getNumVendors()];
        Thread vendorThread;

        System.out.println(vendors.length);
        for(int i = 0; i < vendors.length; i++){
            vendors[i] = new SimVendor("0"+i, simConfigDTO.getTicketPerRelease(), configuration.getTicketReleaseRate(), simTicketPool1, simConfigDTO.getNumVendors(), simConfigDTO.getNumRelease(), configuration.getTotalTickets());
            vendorThread = new Thread(vendors[i], "vendor" + (i+ 1));
            vendorThread.start();
            System.out.println("Vendor Thread Done");
        }

        SimCustomer[] customers = new SimCustomer[simConfigDTO.getNumCustomer()];
        Thread customerThread = null;

        System.out.println(customers.length);
        for(int j = 0; j < customers.length; j++){
            SimCustomer customer1 = new SimCustomer("0"+j, configuration.getCustomerRetrievalRate(), simTicketPool1, simConfigDTO.getNumCustomer(), simConfigDTO.getTicketPerCustomer());
            customerThread = new Thread(customer1, "customer"+ (j+1));
            customerThread.start();
            System.out.println("Customer Thread Done");
        }

//        if(vendors.length != 0 || customers.length != 0){
//            try {
//                customerThread.join();
//                vendorThread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println("Simulation End!");
//        System.out.println("Exiting System!");
    }
}
