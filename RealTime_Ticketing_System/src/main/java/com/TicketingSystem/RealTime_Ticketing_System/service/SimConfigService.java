package com.TicketingSystem.RealTime_Ticketing_System.service;

import com.TicketingSystem.RealTime_Ticketing_System.dto.SimConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.dto.SimDataDTO;
import com.TicketingSystem.RealTime_Ticketing_System.simFiles.SimMain;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SimConfigService {


    public SimConfigDTO simConfigService(SimConfigDTO simConfigDTO){
        SimMain.setData(simConfigDTO);
        System.out.println(simConfigDTO.getNumTickets());
        return simConfigDTO;
    }

    public SimDataDTO simGetData(){
        SimDataDTO simDataDTO = new SimDataDTO();
        simDataDTO.setTickets(SimMain.simTicketPool1.getTickets());
        simDataDTO.setNumAvailable(SimMain.simTicketPool1.getAvailable());
        simDataDTO.setNumSold(SimMain.simTicketPool1.getNumSold());
        simDataDTO.setNumDue(SimMain.simTicketPool1.getDue());
        return simDataDTO;
    }
}
