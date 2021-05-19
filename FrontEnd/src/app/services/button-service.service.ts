import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ButtonServiceService {

  constructor(private http: HttpClient) {
  }

  private buttonUrl = 'http://127.0.0.1/api/command';

  postCommand(id): Observable<any>{
    return this.http.post(this.buttonUrl, id);
  }
}
