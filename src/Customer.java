public class Customer implements Runnable{
    private String customerId;
    private int retrievalInterval;

    public Customer(String customerId, int retrievalInterval){
        this.customerId = customerId;
        this.retrievalInterval = retrievalInterval;
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
        System.out.println("This is Customer class run Method");
        System.out.println(Thread.currentThread().getName());
    }
}
