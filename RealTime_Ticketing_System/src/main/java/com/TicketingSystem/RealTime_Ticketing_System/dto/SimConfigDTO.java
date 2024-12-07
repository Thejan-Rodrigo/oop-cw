package com.TicketingSystem.RealTime_Ticketing_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimConfigDTO {
    private int numTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;
    private int numCustomer;
    private int ticketPerCustomer;
    private int numVendors;
    private int ticketPerRelease;
    private int numRelease;

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

    public int getNumCustomer() {
        return numCustomer;
    }

    public int getTicketPerCustomer() {
        return ticketPerCustomer;
    }

    public int getNumVendors() {
        return numVendors;
    }

    public int getTicketPerRelease() {
        return ticketPerRelease;
    }

    public int getNumRelease() {
        return numRelease;
    }
}
