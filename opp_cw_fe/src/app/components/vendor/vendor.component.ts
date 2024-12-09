import { Component } from '@angular/core';
import { ConfigFormComponent } from '../config-form/config-form.component';
import { CommonModule } from '@angular/common';
import { SimConfigFormComponent } from '../sim-config-form/sim-config-form.component';
import { TicketPoolComponent } from '../ticket-pool/ticket-pool.component';

@Component({
  selector: 'app-vendor',
  standalone: true,
  imports: [ConfigFormComponent, SimConfigFormComponent, CommonModule, TicketPoolComponent],
  templateUrl: './vendor.component.html',
  styleUrl: './vendor.component.css'
})
export class VendorComponent {

  currentComponent: string = 'ticketPool'

  changeTab(tabName: string){
    this.currentComponent = tabName;
  }

  public childData($event: string): void{
    this.changeTab($event)
  }

}
