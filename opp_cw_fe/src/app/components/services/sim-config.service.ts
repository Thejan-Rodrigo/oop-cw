import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sim_Config } from '../model/class/Sim_Config';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SimConfigService {

  constructor(private http:HttpClient) { }

  postConfig(obj:Sim_Config):Observable<Sim_Config>{
    return this.http.post<Sim_Config>(environment.API_URL+"sim_config/post", obj)
  }
}
