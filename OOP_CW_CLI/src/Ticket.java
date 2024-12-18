import java.math.BigDecimal;

public class Ticket {
    //Get these parameters to create a good Ticket Object
    private int ticketId;
    private String eventName;
    private double ticketPrice;

    //Create a constructor for initialize object
    public Ticket(int ticketId, String eventName, double ticketPrice){
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    //Implement Getter Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    //Override toString Method
    @Override
    public String toString(){
        return "Ticket{ticketId=" + ticketId + ", eventName='" + eventName + ", ticketPrice=" + ticketPrice + "}";
    }
}
