import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {State} from "../models/state.model";

@Injectable({
  providedIn: 'root'
})
export class StateService {

  private stateUrl = 'http://127.0.0.1:8080/api/state/get';

  constructor(private http: HttpClient) { }

  getStateData(): Observable<State> {
    return this.http.get<State>(this.stateUrl);
  }
}
