package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.Main;
import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static com.TicketingSystem.RealTime_Ticketing_System.Main.testString;

@Service
@Transactional
public class ConfigService {


    public ConfigDTO configService(ConfigDTO configDTO){
        System.out.println(configDTO.getNumTickets());
        return configDTO;
    }

}
