package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.Main;
import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.TicketPool;
import com.TicketingSystem.RealTime_Ticketing_System.dto.TicketDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketService {


    public Ticket[] ticketService(TicketDTO ticketDTO){
        System.out.println(ticketDTO.getEventName());
        System.out.println(ticketDTO.getPrice());
        Main.setTicket(ticketDTO, ConfigService.ticketPool);
        return ConfigService.ticketPool.getTickets();
    }

    public Ticket[] getTicketsArray(){
        return ConfigService.ticketPool.getTickets();
    }
}
