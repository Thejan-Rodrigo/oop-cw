package com.TicketingSystem.RealTime_Ticketing_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDTO {
    private int ticketId;
    private String eventName;
    private int price;
    private int numTickets;

    public String getEventName() {
        return eventName;
    }

    public int getPrice() {
        return price;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public int getTicketId() {
        return ticketId;
    }
}
