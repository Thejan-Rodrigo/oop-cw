package com.TicketingSystem.RealTime_Ticketing_System.dto;

import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import com.TicketingSystem.RealTime_Ticketing_System.simFiles.SimTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimDataDTO {
    private int numAvailable;
    private int numSold;
    private SimTicket[] tickets;
    private int numDue;

    public int getNumAvailable() {
        return numAvailable;
    }

    public int getNumSold() {
        return numSold;
    }

    public SimTicket[] getTickets() {
        return tickets;
    }

    public int getNumDue() {
        return numDue;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }

    public void setTickets(SimTicket[] tickets) {
        this.tickets = tickets;
    }

    public void setNumDue(int numDue) {
        this.numDue = numDue;
    }
}
