package com.TicketingSystem.RealTime_Ticketing_System.simFiles;

public class SimCustomer implements Runnable{
    private String customerId;
    private int retrievalInterval;
    private SimTicketPool ticketPool;
    private int numCustomer;
    private int ticketPerCustomer;

    public SimCustomer(String customerId, int retrievalInterval, SimTicketPool ticketPool, int numCustomer, int ticketPerCustomer){
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketPool = ticketPool;
        this.numCustomer = numCustomer;
        this.ticketPerCustomer = ticketPerCustomer;
    }

    public String getCustomer() {
        return customerId;
    }

    public void setCustomer(String customer) {
        this.customerId = customer;
    }

    public int getRetrievalInterval() {
        return retrievalInterval;
    }

    public void setRetrievalInterval(int retrievalInterval) {
        this.retrievalInterval = retrievalInterval;
    }

    public int getNumCustomer() {
        return numCustomer;
    }

    public void setNumCustomer(int numCustomer) {
        this.numCustomer = numCustomer;
    }

    public int getTicketPerCustomer() {
        return ticketPerCustomer;
    }

    public void setTicketPerCustomer(int ticketPerCustomer) {
        this.ticketPerCustomer = ticketPerCustomer;
    }

    @Override
    public void run(){
        for(int i = 0; i < ticketPerCustomer; i++){
            System.out.println(Thread.currentThread().getName() + "   Release number" + (i+1));
            SimTicket ticket = this.ticketPool.removeTickets();
            //System.out.println("Ticket is - " + ticket + " - Customer name is - " + Thread.currentThread().getName());

            try {
                Thread.sleep(retrievalInterval * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println("This is Customer class run Method");
        //System.out.println(Thread.currentThread().getName());
    }
}
