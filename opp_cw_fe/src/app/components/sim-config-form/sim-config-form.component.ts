import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Sim_Config } from '../model/class/Sim_Config';
import { SimConfigService } from '../services/sim-config.service';

@Component({
  selector: 'app-sim-config-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sim-config-form.component.html',
  styleUrl: './sim-config-form.component.css'
})
export class SimConfigFormComponent {
  sim_configObj: Sim_Config = new Sim_Config();

  sim_configService = inject(SimConfigService);

  onClickSimStart(){
    this.sim_configService.postConfig(this.sim_configObj).subscribe((res:Sim_Config)=>{
      alert(res.ticketPerCustomer)
    })
  }
}
