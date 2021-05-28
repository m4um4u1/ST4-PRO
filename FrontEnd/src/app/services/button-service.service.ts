import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ButtonServiceService {

  constructor(private http: HttpClient) {
  }

  private buttonUrl = 'http://127.0.0.1:8080/api/command';

  postCommand(id: number): Observable<any>{
    return this.http.post(`${this.buttonUrl}/${id}`, id);
  }
}
