package com.TicketingSystem.RealTime_Ticketing_System;

import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.dto.TicketDTO;
import org.apache.log4j.BasicConfigurator;

public class Main {
    public static void setConfiguration(ConfigDTO configDTO){
        BasicConfigurator.configure();
        TicketPool ticketPool1;
        Configuration configuration = new Configuration(configDTO.getNumTickets(), configDTO.getReleaseRate(), configDTO.getRetrievalRate(), configDTO.getTicketCapacity());

        configuration.saveConfig(configuration);
        configuration.loadConfig();

    }
    public static void setTicket(TicketDTO ticketDTO, TicketPool ticketPool1){
        for(int i = 0; i < ticketDTO.getNumTickets(); i++){
            Ticket ticket = new Ticket(ticketDTO.getTicketId() + i, ticketDTO.getEventName(), ticketDTO.getPrice());
            ticketPool1.addTickets(ticket);
            System.out.println(ticketPool1.getVectorSize());
        }
    }

    public static TicketPool newTicketPool(int max){
        return new TicketPool(max);
    }

}
