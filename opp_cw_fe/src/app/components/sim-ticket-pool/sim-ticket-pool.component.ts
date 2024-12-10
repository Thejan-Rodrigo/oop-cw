import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ticket } from '../model/class/Ticket';
import { TicketService } from '../services/ticket.service';
import SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';
import { environment } from '../../../environments/environment.development';

@Component({
  selector: 'app-sim-ticket-pool',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sim-ticket-pool.component.html',
  styleUrl: './sim-ticket-pool.component.css'
})
export class SimTicketPoolComponent implements OnInit{

  ngOnInit(): void {
  }


  ticketObj: Ticket = new Ticket()
  ticketList: Ticket[] = [];
  
  ticketService = inject(TicketService)

  ticketsNum: number = 5;

  ticketsSold: number = 10;

  ticketsAdd: number = 15;
}
