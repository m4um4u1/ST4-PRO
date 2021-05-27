import { Injectable } from '@angular/core';
import {LiveData} from '../../../models/live-data.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LiveDataService {
  liveDataUrl = 'http://127.0.0.1/api/get/liveData';

  constructor(private http: HttpClient) { }

  fetchLiveData(): void {
    this.http.get<LiveData>(this.liveDataUrl).subscribe(data => {
      console.log(data);
    });
  }
}
