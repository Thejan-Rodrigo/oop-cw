import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Ticket } from '../model/class/Ticket';
import { environment } from '../../../environments/environment.development';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private http: HttpClient) { }

  postTicket(obj:Ticket):Observable<Ticket>{
    alert("Hello")
    return this.http.post<Ticket>(environment.API_URL+"ticket/post", obj)
  }

  getTicket():Observable<Ticket[]>{
    return this.http.get<Ticket[]>(environment.API_URL+"ticket/get")
  }
}
