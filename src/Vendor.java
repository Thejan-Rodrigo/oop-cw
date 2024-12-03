public class Vendor implements Runnable{
    private String vendorId;
    private int ticketsPerRelease;
    private int releaseInterval;

    public Vendor(String vendorId, int ticketsPerRelease, int releaseInterval){
        this.vendorId = vendorId;
        this.ticketsPerRelease = ticketsPerRelease;
        this.releaseInterval = releaseInterval;
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
        System.out.println("This is Vendor Class run Methode");
        System.out.println(Thread.currentThread().getName());
    }


}
