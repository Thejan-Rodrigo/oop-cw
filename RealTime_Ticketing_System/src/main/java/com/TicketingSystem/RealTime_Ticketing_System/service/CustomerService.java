package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.Main;
import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.dto.CustomerDataDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {
    public Ticket[] setCustomer(CustomerDataDTO customerDataDTO){
        for(int i = 0; i<customerDataDTO.getNumTickets(); i++){
            ConfigService.ticketPool.removeTickets();
        }

        return ConfigService.ticketPool.getTickets();
    }

    public Ticket[] getCustomer(){
        return ConfigService.ticketPool.getTickets();
    }
}
