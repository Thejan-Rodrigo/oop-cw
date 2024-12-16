import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ticket } from '../model/class/Ticket';
import { TicketService } from '../services/ticket.service';
import SockJS from 'sockjs-client';
import * as Stomp from 'stompjs';
import { environment } from '../../../environments/environment.development';
import { Sim_Config } from '../model/class/Sim_Config';
import { SimConfigService } from '../services/sim-config.service';
import { Sim_Data } from '../model/class/Sim_Data';
import { Sim_Ticket } from '../model/class/Sim_Ticket';

@Component({
  selector: 'app-sim-ticket-pool',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sim-ticket-pool.component.html',
  styleUrl: './sim-ticket-pool.component.css'
})
export class SimTicketPoolComponent implements OnInit{

  ngOnInit(): void {
    this.startPolling()
  }


  sim_configObj: Sim_Config = new Sim_Config();
  pollingService: any;
  isPolling: boolean = false;

  ticketObj: Sim_Ticket = new Sim_Ticket()
  ticketList: Sim_Ticket[] = [];
  
  sim_configService = inject(SimConfigService);

  ticketsNum: number = 0;

  ticketsSold: number = 0;

  ticketsDue: number = 0;


  startPolling() {
    this.sim_configService.pollingSubscription = this.sim_configService.getData().subscribe(data => {
      this.ticketsNum = data.numAvailable
      this.ticketsDue = data.numDue
      this.ticketList = data.tickets
      this.ticketsSold = data.numSold
      // Handle the received data
      this.isPolling = true;
      console.log(data);
      console.log(this.ticketsSold)
    });
  }

  stopPolling() {
    this.sim_configService.stopPolling$.next();
    this.sim_configService.pollingSubscription.unsubscribe();
    this.isPolling = false;
  }




  // stratClick(){
  //   this.sim_configService.startPolling();
  //   alert(this.ticketsNum)
  // }

  // stopClick(){
  //   this.sim_configService.stopPolling();
  // }


  //[disabled]="isPolling" (click)="startPolling()"
  //[disabled]="!isPolling" (click)="stopPolling()"
}
