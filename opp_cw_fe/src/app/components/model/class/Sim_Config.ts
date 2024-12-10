export class Sim_Config{
    numTickets: number;
    releaseRate: number;
    retrievalRate: number;
    ticketCapacity: number;
    numCustomer: number;
    ticketPerCustomer: number;
    numVendors: number;
    ticketPerRelease:number;
    numRelease: number;

    constructor(){
        this.numTickets = 0;
        this.releaseRate = 0;
        this.retrievalRate = 0;
        this.ticketCapacity = 0;
        this.numCustomer = 0;
        this.ticketPerCustomer = 0;
        this.numVendors = 0;
        this.ticketPerRelease = 0;
        this.numRelease = 0;
        
    }
}