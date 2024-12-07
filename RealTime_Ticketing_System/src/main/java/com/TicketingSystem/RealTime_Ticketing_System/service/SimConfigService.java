package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.dto.SimConfigDTO;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SimConfigService {

    public SimConfigDTO simConfigService(SimConfigDTO simConfigDTO){
        System.out.println(simConfigDTO.getNumTickets());
        return simConfigDTO;
    }
}
