package com.TicketingSystem.RealTime_Ticketing_System;

import com.TicketingSystem.RealTime_Ticketing_System.dto.TicketDTO;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Vector;

public class TicketPool {
    private int maximumTicketCapacity;
    private List<Ticket> vector;
    private int count = 0;
    private static Logger logger = Logger.getLogger(TicketPool.class);

    public TicketPool(int maximumTicketCapacity){
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.vector = new Vector<>();
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

    public int getVectorSize() {
        return vector.size();
    }

    public synchronized void addTickets(Ticket ticket){
        while(vector.size() >= maximumTicketCapacity){
            try {
                logger.warn("Ticket Pool is full! Please wait for someone to buy");
                wait();
            } catch (InterruptedException e) {
                logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }


        this.vector.add(ticket);
        logger.info("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + this.vector.size());
        notifyAll();
    }

    public synchronized Ticket removeTickets(){
        while(vector.isEmpty()){
            try {
                logger.warn("Ticket Pool is Empty! Please wait Vendor to add");
                wait();
            } catch (InterruptedException e) {
                logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }

        Ticket ticket = this.vector.remove(0);
        logger.info("Ticket bought by - " + Thread.currentThread().getName() + "- current size is - "+ vector.size() + " - Ticket is - " + ticket + " ");
        notifyAll();
        return ticket;
    }

    public Ticket[] getTickets(){
        Ticket[] tickets = new Ticket[vector.size()];
        for(int i = 0; i < vector.size(); i++){
            tickets[i] = vector.get(i);
        }
        return tickets;
    }
}
