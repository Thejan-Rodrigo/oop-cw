package com.TicketingSystem.RealTime_Ticketing_System.simFiles;

public class SimVendor implements Runnable{
    private String vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private SimTicketPool ticketPool;
    private int numVendors;
    private int numReleases;
    private int totTickets;

    public SimVendor(String vendorId, int ticketsPerRelease, int releaseInterval, SimTicketPool ticketPool, int numVendors, int numReleases, int totTickets){
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
        this.numVendors = numVendors;
        this.numReleases = numReleases;
        this.totTickets = totTickets;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public int getTicketsPerRelease() {
        return ticketsPerRelease;
    }

    public void setTicketsPerRelease(int ticketsPerRelease) {
        this.ticketsPerRelease = ticketsPerRelease;
    }

    public int getReleaseInterval() {
        return releaseInterval;
    }

    public void setReleaseInterval(int releaseInterval) {
        this.releaseInterval = releaseInterval;
    }

    public int getNumVendors() {
        return numVendors;
    }

    public void setNumVendors(int numVendors) {
        this.numVendors = numVendors;
    }

    public int getNumReleases() {
        return numReleases;
    }

    public void setNumReleases(int numReleases) {
        this.numReleases = numReleases;
    }

    public int getTotTickets() {
        return totTickets;
    }

    public void setTotTickets(int totTickets) {
        this.totTickets = totTickets;
    }

    @Override
    public void run(){
        for(int i = 0; i < numReleases ; i++){
            for (int j = 0; j < ticketsPerRelease ; j++) {
                SimTicket newTicket = new SimTicket(55441 + ticketPool.getCount(), "Hello", 2500);
                ticketPool.addTickets(newTicket);
                ticketPool.setCount(ticketPool.getCount() + 1);
                //System.out.println("This is Vendor Class run Methode");
                // System.out.println(newTicket.toString());
            }
            try {
                Thread.sleep(releaseInterval * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //Ticket newTicket = new Ticket(554466,"Hello", 25.00);
        //ticketPool.addTickets(newTicket);
        //System.out.println("This is Vendor Class run Methode");
        //System.out.println(newTicket.toString());
    }
}
