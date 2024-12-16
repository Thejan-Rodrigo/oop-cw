import org.apache.log4j.Logger;

import java.util.List;
import java.util.Vector;

public class TicketPool {
    //Get these parameters to run the Ticket pool class
    private int maximumTicketCapacity;
    private List<Ticket> vector;
    private int count = 0;
    private static Logger logger = Logger.getLogger(TicketPool.class);

    //Create a constructor for initialize object
    public TicketPool(int maximumTicketCapacity){
        this.maximumTicketCapacity = maximumTicketCapacity;
        this.vector = new Vector<>();
    }

    //Implement Getters Setters
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

    //Add ticket method for vendors to add the tickets to the ticket pool
    public synchronized void addTickets(Ticket ticket){
        //Checking the ticket pool has ticket more the User input maximumCapacity
        while(vector.size() >= maximumTicketCapacity){
            try {
                //If it does put Thread in to wait state
                logger.warn("Ticket Pool is full! Please wait for someone to buy");
                wait();
            } catch (InterruptedException e) {
                //Handle Error
                logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }

        //If not adding ticket to the ticket pool
        this.vector.addLast(ticket);
        logger.info("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + this.vector.size());
        //After notify all
        notifyAll();
    }

    //Remove ticket method for customer to buy the tickets that in the ticket pool
    public synchronized Ticket removeTickets(){
        //Check is it Ticket pool is Empty
        while(vector.isEmpty()){
            try {
                //If it does put Thread in to wait state
                logger.warn("Ticket Pool is Empty! Please wait Vendor to add");
                wait();
            } catch (InterruptedException e) {
                logger.error("InterruptedException");
                throw new RuntimeException(e);
            }
        }

        //If not remove tickets in out of ticket pool
        Ticket ticket = this.vector.removeFirst();
        logger.info("Ticket bought by - " + Thread.currentThread().getName() + "- current size is - "+ vector.size() + " - Ticket is - " + ticket + " ");
        //After notify all
        notifyAll();
        return ticket;
    }
}
