import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Configure } from '../model/class/Configure';

@Component({
  selector: 'app-config-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './config-form.component.html',
  styleUrl: './config-form.component.css'
})
export class ConfigFormComponent {
  
  configureObj: Configure = new Configure();

  onClickStart(){
    console.log(this.configureObj.numTickets)
  }
}
