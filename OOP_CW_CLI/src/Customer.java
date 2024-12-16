public class Customer implements Runnable{
    //Implements the runnable method for create a thread and override the rum method

    //Get these parameters to run the Customer Thread
    private String customerId;
    private int retrievalInterval;
    private TicketPool ticketPool;
    private int numCustomer;
    private int ticketPerCustomer;

    //Create a constructor for initialize object
    public Customer(String customerId, int retrievalInterval, TicketPool ticketPool, int numCustomer, int ticketPerCustomer){
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
        this.ticketPool = ticketPool;
        this.numCustomer = numCustomer;
        this.ticketPerCustomer = ticketPerCustomer;
    }

    //Implement Getters Setters
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

    //Override the run method
    @Override
    public void run(){
        //Buy Ticket according to the user inputs
        for(int i = 0; i < ticketPerCustomer; i++){
            Ticket ticket = this.ticketPool.removeTickets();

            //sleep the thread according to the User Input
            try {
                Thread.sleep(retrievalInterval * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
