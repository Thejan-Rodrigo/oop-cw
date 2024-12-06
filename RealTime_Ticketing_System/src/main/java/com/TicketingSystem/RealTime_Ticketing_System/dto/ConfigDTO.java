package com.TicketingSystem.RealTime_Ticketing_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConfigDTO {
    private int numTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;

    public int getNumTickets() {
        return numTickets;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public int getTicketCapacity() {
        return ticketCapacity;
    }
}
