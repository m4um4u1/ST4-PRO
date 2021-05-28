import { Injectable } from '@angular/core';
import {LiveData} from '../models/live-data.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LiveDataService {
  liveDataUrl = 'http://127.0.0.1:8080/api/liveData/get';

  constructor(private http: HttpClient) { }

  fetchLiveData(): Observable<LiveData>{
    return this.http.get<LiveData>(this.liveDataUrl);
  }
}
