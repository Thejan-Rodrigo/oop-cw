import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sim_Config } from '../model/class/Sim_Config';
import { environment } from '../../../environments/environment.development';
import { interval, map, Observable, Subject, Subscription, switchMap, takeUntil } from 'rxjs';
import { Sim_Ticket } from '../model/class/Sim_Ticket';
import { Sim_Data } from '../model/class/Sim_Data';

@Injectable({
  providedIn: 'root'
})
export class SimConfigService {
  private pollingSubscription: Subscription = new Subscription();;
  private stopPolling$ = new Subject<void>();

  constructor(private http:HttpClient) { }

  postConfig(obj:Sim_Config):Observable<Sim_Config>{
    return this.http.post<Sim_Config>(environment.API_URL+"sim_config/post", obj)
  }

  getData(): Observable<Sim_Data> {
    return interval(2000).pipe(
      takeUntil(this.stopPolling$),
      switchMap(() => this.http.get<Sim_Data>(environment.API_URL + 'sim_config/get')),
      map(response => response)
    );
  }
  
  startPolling() {
    this.pollingSubscription = this.getData().subscribe(data => {
      // Handle the received data
      console.log(data);
    });
  }

  stopPolling() {
    this.stopPolling$.next();
    this.pollingSubscription.unsubscribe();
  }

}
