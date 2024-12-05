public class Vendor implements Runnable{
    private String vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;
    private TicketPool ticketPool;

    public Vendor(String vendorId, int ticketsPerRelease, int releaseInterval, TicketPool ticketPool){
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
        this.ticketPool = ticketPool;
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

    @Override
    public void run(){
        for(int i = 0; i < ticketsPerRelease - 1; i++){
            Ticket newTicket = new Ticket(55441 + i,"Hello", 25.00);
            ticketPool.addTickets(newTicket);
            //System.out.println("This is Vendor Class run Methode");
            //System.out.println(newTicket.toString());
        }

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Ticket newTicket = new Ticket(554466,"Hello", 25.00);
        ticketPool.addTickets(newTicket);
        //System.out.println("This is Vendor Class run Methode");
        //System.out.println(newTicket.toString());

    }


}
