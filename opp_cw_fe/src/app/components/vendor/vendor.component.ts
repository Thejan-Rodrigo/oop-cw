import { Component } from '@angular/core';
import { ConfigFormComponent } from '../config-form/config-form.component';

@Component({
  selector: 'app-vendor',
  standalone: true,
  imports: [ConfigFormComponent],
  templateUrl: './vendor.component.html',
  styleUrl: './vendor.component.css'
})
export class VendorComponent {

}
