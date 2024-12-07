package com.TicketingSystem.RealTime_Ticketing_System.controller;

import com.TicketingSystem.RealTime_Ticketing_System.dto.SimConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.service.SimConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/sim_config")
@CrossOrigin
public class SimConfigController {

    @Autowired
    private SimConfigService simConfigService;

    @PostMapping("/post")
    public SimConfigDTO simConfigService(@RequestBody SimConfigDTO simConfigDTO){
        return simConfigService.simConfigService(simConfigDTO);
    }
}
