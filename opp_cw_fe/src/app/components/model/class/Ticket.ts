export class Ticket{
    ticketId: number;
    eventName: string;
    price: number;
    numTickets: number;

    constructor(){
        this.ticketId = 0;
        this.eventName = '';
        this.price = 0;
        this.numTickets = 0;
    }
}