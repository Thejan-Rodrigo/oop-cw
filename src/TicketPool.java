import java.util.List;
import java.util.Vector;

public class TicketPool {
    private int maximumTicketCapacity;
    private List<Ticket> vector;

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

    public synchronized void addTickets(Ticket ticket){
        while(vector.size() >= maximumTicketCapacity){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.vector.addLast(ticket);
        notifyAll();
        System.out.println("Ticket added by - " + Thread.currentThread().getName() + " - current size is - " + this.vector.size());
    }

    public synchronized Ticket removeTickets(){
        while(vector.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Ticket ticket = this.vector.removeFirst();
        notifyAll();
        System.out.println("Ticket bought by - " + Thread.currentThread().getName() + " - current size is - " + vector.size() + " - Ticket is - " + ticket);
        return ticket;
    }
}
