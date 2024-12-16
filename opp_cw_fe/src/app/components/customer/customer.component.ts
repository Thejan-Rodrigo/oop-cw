import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Customer_Data } from '../model/class/Customer_Data';
import { CustomerService } from '../services/customer.service';
import { Ticket } from '../model/class/Ticket';

@Component({
  selector: 'app-customer',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './customer.component.html',
  styleUrl: './customer.component.css'
})
export class CustomerComponent implements OnInit{
  customerDataObj: Customer_Data = new Customer_Data()
  ticketList: Ticket[] = [];

  customerService = inject(CustomerService)

  ngOnInit(): void {
    this.customerService.getTickets().subscribe((res:Ticket[])=>{
      this.ticketList=res
    })
  }

  onCustomerClick(){
    this.customerService.postConfig(this.customerDataObj).subscribe((res:Ticket[])=>{
      this.ticketList=res;
    })
  }
}
