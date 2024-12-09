import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
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
export class TicketPoolComponent {
  ticketObj: Ticket = new Ticket()
  ticketList: Ticket[] = [];

  ticketService = inject(TicketService)

  onTicketClick(){
    this.ticketService.postTicket(this.ticketObj).subscribe((res: Ticket)=>{
      alert(res.eventName)
    })
  }

}
