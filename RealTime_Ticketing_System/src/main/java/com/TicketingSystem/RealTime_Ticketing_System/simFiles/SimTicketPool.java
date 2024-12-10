package com.TicketingSystem.RealTime_Ticketing_System.simFiles;

import com.TicketingSystem.RealTime_Ticketing_System.Ticket;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Vector;

public class SimTicketPool {
    private int maximumTicketCapacity;
    private List<SimTicket> vector;
    private int count = 0;
    private int sold = 0;
    private int totalTicket;
    //private static Logger logger = Logger.getLogger(SimTicketPool.class);

    public SimTicketPool(int maximumTicketCapacity, int totalTicket){
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.vector = new Vector<>();
        this.totalTicket = totalTicket;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        this.totalTicket = totalTicket;
    }

    public List<SimTicket> getVector() {
        return vector;
    }

    public void setVector(List<SimTicket> vector) {
        this.vector = vector;
    }

    public synchronized void addTickets(SimTicket ticket){
        while(vector.size() >= maximumTicketCapacity){
            try {
                //logger.warn("Ticket Pool is full! Please wait for someone to buy");
                System.out.println("Ticket Pool is full! Please wait for someone to buy");
                wait();
                System.out.println("Add ticket OUT");
            } catch (InterruptedException e) {
                //logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }

        this.vector.add(ticket);

        //logger.info("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + this.vector.size());
        System.out.println("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + this.vector.size());
        notifyAll();
    }

    public synchronized SimTicket removeTickets(){
        while(vector.isEmpty()){
            try {
                //logger.warn("Ticket Pool is Empty! Please wait Vendor to add");
                System.out.println("Ticket Pool is Empty! Please wait Vendor to add");
                wait();
                System.out.println("remove ticket OUT");
            } catch (InterruptedException e) {
                //logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }

        SimTicket ticket = this.vector.remove(0);
        this.sold++;
        //logger.info("Ticket bought by - " + Thread.currentThread().getName() + "- current size is - "+ vector.size() + " - Ticket is - " + ticket + " ");
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + "- current size is - "+ vector.size() + " - Ticket is - " + ticket + " ");
        notifyAll();
        return ticket;
    }

    public SimTicket[] getTickets(){
        SimTicket[] tickets = new SimTicket[vector.size()];
        for(int i = 0; i < vector.size(); i++){
            tickets[i] = vector.get(i);
        }
        return tickets;
    }

    public int getDue(){
        return totalTicket - this.sold;
    }

    public int getNumSold(){
        return this.sold;
    }

    public int getAvailable(){
        return vector.size();
    }
}
