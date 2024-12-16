package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.Main;
import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.TicketPool;
import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.entity.ConfigurationEntity;
import com.TicketingSystem.RealTime_Ticketing_System.repo.ConfigurationRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ConfigService {


    ConfigurationRepo configurationRepo;

    @Autowired
    private ModelMapper modelMapper;

    public static TicketPool ticketPool;
    public  Ticket[] configService(ConfigDTO configDTO){
        ticketPool = new TicketPool(configDTO.getTicketCapacity());
        Main.setConfiguration(configDTO);
        //configurationRepo.save(modelMapper.map(configDTO, ConfigurationEntity.class));
        return ticketPool.getTickets();
    }
}
