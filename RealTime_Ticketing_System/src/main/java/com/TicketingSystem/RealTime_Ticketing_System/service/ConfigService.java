package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.Configuration;
import com.TicketingSystem.RealTime_Ticketing_System.Main;
import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.TicketPool;
import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ConfigService {
    public static TicketPool ticketPool;
    public  Ticket[] configService(ConfigDTO configDTO){
        ticketPool = new TicketPool(configDTO.getTicketCapacity());
        Main.setConfiguration(configDTO);
        return ticketPool.getTickets();
    }

}
