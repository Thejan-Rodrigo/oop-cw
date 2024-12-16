public class Vendor implements Runnable{
    //Implements the runnable method for create a thread and override the rum method

    //Get these parameters to run the vendor thread
    private String vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;
    private int numVendors;
    private int numReleases;
    private int totTickets;
    private String eventName;
    private int ticketPrice;

    //Create a constructor for initialize object
    public Vendor(String vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool, int numVendors, int numReleases, int totTickets, String eventName, int ticketPrice){
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
        this.numVendors = numVendors;
        this.numReleases = numReleases;
        this.totTickets = totTickets;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    //Implement Getter Setters
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //Override run method
    @Override
    public void run(){
        for(int i = 0; i < numReleases ; i++){
            //creating Ticket according to the user inputs
            for (int j = 0; j < ticketsPerRelease ; j++) {
                Ticket newTicket = new Ticket(55441 + ticketPool.getCount(), eventName, ticketPrice);
                ticketPool.addTickets(newTicket);
                ticketPool.setCount(ticketPool.getCount() + 1);
            }
            //sleep the thread according to the User Input
            try {
                Thread.sleep(releaseInterval * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
