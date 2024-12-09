package com.TicketingSystem.RealTime_Ticketing_System;

import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.dto.TicketDTO;

public class Main {
    public static void setConfiguration(ConfigDTO configDTO){
        TicketPool ticketPool1;
        Configuration configuration = new Configuration(configDTO.getNumTickets(), configDTO.getReleaseRate(), configDTO.getRetrievalRate(), configDTO.getTicketCapacity());

        configuration.saveConfig(configuration);
        configuration.loadConfig();

    }
    public static void setTicket(TicketDTO ticketDTO, TicketPool ticketPool1){
        for(int i = 0; i < 5; i++){
            Ticket ticket = new Ticket(1 + i, ticketDTO.getEventName(), ticketDTO.getPrice());
            ticketPool1.addTickets(ticket);
            System.out.println(ticketPool1.getVectorSize());
        }
    }

    public static TicketPool newTicketPool(int max){
        return new TicketPool(max);
    }

}
