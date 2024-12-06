import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Configure } from '../model/class/Configure';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  constructor(private http: HttpClient) {}

  postConfig(obj:Configure):Observable<Configure>{
    return this.http.post<Configure>(environment.API_URL+"config/post", obj)
  }
}
