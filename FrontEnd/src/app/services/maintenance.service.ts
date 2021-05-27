import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MaintenanceService {

  private mtUrl = 'http://127.0.0.1/api/get/mtData';

  constructor(private http: HttpClient) { }

  getMtData(): void{
    this.http.get<number>(this.mtUrl).subscribe(data => {
      console.log(data);
    });
  }
}
