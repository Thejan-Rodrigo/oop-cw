package com.TicketingSystem.RealTime_Ticketing_System.simFiles;

public class SimTicket {
    private int ticketId;
    private String eventName;
    private int ticketPrice;

    public SimTicket(int ticketId, String eventName, int ticketPrice){
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString(){
        return "Ticket{ticketId=" + ticketId + ", eventName='" + eventName + ", ticketPrice=" + ticketPrice + "}";
    }
}
