package com.TicketingSystem.RealTime_Ticketing_System.controller;

import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.dto.TicketDTO;
import com.TicketingSystem.RealTime_Ticketing_System.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/post")
    public Ticket[] postTicket(@RequestBody TicketDTO ticketDTO){
        return ticketService.ticketService(ticketDTO);
    }

    @GetMapping("/get")
    public Ticket[] getTicket(){
        return ticketService.getTicketsArray();
    }
}
