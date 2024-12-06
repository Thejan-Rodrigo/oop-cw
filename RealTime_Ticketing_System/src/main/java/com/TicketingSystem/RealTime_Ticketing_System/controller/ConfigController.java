package com.TicketingSystem.RealTime_Ticketing_System.controller;

import com.TicketingSystem.RealTime_Ticketing_System.dto.ConfigDTO;
import com.TicketingSystem.RealTime_Ticketing_System.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/config")
@CrossOrigin
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @PostMapping("/post")
    public ConfigDTO postConfig(@RequestBody ConfigDTO configDTO){
        return configService.configService(configDTO);
    }
}
