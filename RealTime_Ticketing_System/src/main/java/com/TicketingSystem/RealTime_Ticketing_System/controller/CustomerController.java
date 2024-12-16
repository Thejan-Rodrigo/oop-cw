package com.TicketingSystem.RealTime_Ticketing_System.controller;

import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.dto.CustomerDataDTO;
import com.TicketingSystem.RealTime_Ticketing_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/post")
    public Ticket[] postCustomer(@RequestBody CustomerDataDTO customerDataDTO){
        return customerService.setCustomer(customerDataDTO);
    }

    @GetMapping("/get")
    public Ticket[] getCustomer(){
        return customerService.getCustomer();
    }
}
