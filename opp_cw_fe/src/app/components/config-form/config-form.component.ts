import { Component, EventEmitter, inject, Output, output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Configure } from '../model/class/Configure';
import { ConfigService } from '../services/config.service';

@Component({
  selector: 'app-config-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './config-form.component.html',
  styleUrl: './config-form.component.css'
})
export class ConfigFormComponent {

  @Output() myData = new EventEmitter<string>();
  
  currentConfigComponent: string = ''

  configureObj: Configure = new Configure();

  configService = inject(ConfigService);

  onClickStart(){
    this.configService.postConfig(this.configureObj).subscribe((res:Configure)=>{
      alert(res.numTickets)
    })

    this.changeSimTab('ticketPool')

    this.myData.emit(this.currentConfigComponent)

  }

  changeSimTab(tabName: string){
    this.currentConfigComponent = tabName;
  }
}


