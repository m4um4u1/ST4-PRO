import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Maintenance} from '../models/maintenance.model';

@Injectable({
  providedIn: 'root'
})
export class MaintenanceService {

  private mtUrl = 'http://127.0.0.1:8080/api/maintenance/get';

  constructor(private http: HttpClient) { }

  getMtData(): Observable<Maintenance> {
    return this.http.get<Maintenance>(this.mtUrl);
  }
}
