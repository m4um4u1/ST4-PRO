import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ButtonServiceService {

  constructor(private http: HttpClient) {
  }

  private buttonUrl = 'button/start';

  postCommand(id): Observable<any>{
    return this.http.post(this.buttonUrl, id);
  }
}
