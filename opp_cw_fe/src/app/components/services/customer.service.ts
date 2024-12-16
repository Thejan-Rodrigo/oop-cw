import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer_Data } from '../model/class/Customer_Data';
import { Observable } from 'rxjs';
import { Ticket } from '../model/class/Ticket';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) {}

  postConfig(obj:Customer_Data):Observable<Ticket[]>{
    return this.http.post<Ticket[]>(environment.API_URL+"customer/post", obj)
  }

  getTickets():Observable<Ticket[]>{
    return this.http.get<Ticket[]>(environment.API_URL+"customer/get")
  }
}
