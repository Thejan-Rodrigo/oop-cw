package com.TicketingSystem.RealTime_Ticketing_System.dto;

public class CustomerDataDTO {
    private String customerName;
    private int numTickets;

    public String getCustomerName() {
        return customerName;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }
}
