public class Customer implements Runnable{
    private String customerId;
    private int retrievalInterval;
    private TicketPool ticketPool;

    public Customer(String customerId, int retrievalInterval, TicketPool ticketPool){
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketPool = ticketPool;
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

    @Override
    public void run(){
        for(int i = 0; i < 11; i++){
            Ticket ticket = this.ticketPool.removeTickets();
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
