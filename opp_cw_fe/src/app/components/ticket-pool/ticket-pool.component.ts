import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ticket } from '../model/class/Ticket';
import { TicketService } from '../services/ticket.service';

@Component({
  selector: 'app-ticket-pool',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ticket-pool.component.html',
  styleUrl: './ticket-pool.component.css'
})
export class TicketPoolComponent implements OnInit{
  ticketObj: Ticket = new Ticket()
  ticketList: Ticket[] = [];

  ticketService = inject(TicketService)

  ngOnInit(){
    this.loadTable()
  }

  onTicketClick(){
    this.ticketService.postTicket(this.ticketObj).subscribe((res: Ticket)=>{
      alert(res.eventName);
      this.loadTable();
    })
  }

  loadTable(){
    this.ticketService.getTicket().subscribe((res:Ticket[]) => {
      alert(res[1].price);
      this.ticketList = res;
    })
  }

}
