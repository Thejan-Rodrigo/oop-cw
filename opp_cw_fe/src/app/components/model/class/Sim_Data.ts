import { Sim_Ticket } from "./Sim_Ticket";

export class Sim_Data{
    numAvailable: number;
    numSold: number;
    tickets: Sim_Ticket[];
    numDue: number;

    constructor(){
        this.numAvailable = 0;
        this.numSold = 0;
        this.tickets = [];
        this.numDue = 0;
    }

}