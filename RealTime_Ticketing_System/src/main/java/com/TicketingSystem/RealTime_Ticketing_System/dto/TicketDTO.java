package com.TicketingSystem.RealTime_Ticketing_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketDTO {
    private String eventName;
    private int price;

    public String getEventName() {
        return eventName;
    }

    public int getPrice() {
        return price;
    }
}
