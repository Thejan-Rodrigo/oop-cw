package com.TicketingSystem.RealTime_Ticketing_System;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity){
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    @Override
    public String toString(){
        return "{\"totalTickets\":" + this.totalTickets + ",\"ticketReleaseRate\":" + this.ticketReleaseRate + ",\"customerRetrievalRate\":" + this.customerRetrievalRate + ",\"maxTicketCapacity\":" + this.maxTicketCapacity + "}";
    }

    public void saveConfig(Configuration configuration){
        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("configData.json")) {
            gson.toJson(configuration, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadConfig(){
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("configData.json");
            Configuration data = gson.fromJson(reader, Configuration.class);
            //System.out.println(data.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
