package com.TicketingSystem.RealTime_Ticketing_System.WebSocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealTimeData {
    int ticketsNum;
    int ticketsSold;
    int ticketsAdd;

    public int getTicketsNum() {
        return ticketsNum;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public int getTicketsAdd() {
        return ticketsAdd;
    }

    public void setTicketsNum(int ticketsNum) {
        this.ticketsNum = ticketsNum;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public void setTicketsAdd(int ticketsAdd) {
        this.ticketsAdd = ticketsAdd;
    }
}
