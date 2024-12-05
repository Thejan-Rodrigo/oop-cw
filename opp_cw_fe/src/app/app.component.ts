import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ConfigFormComponent } from './components/config-form/config-form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ConfigFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'opp_cw_fe';
}
