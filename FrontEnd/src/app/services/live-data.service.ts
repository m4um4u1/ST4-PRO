import { Injectable } from '@angular/core';
import {LiveData} from '../../../models/live-data.model';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LiveDataService {

  liveData: LiveData;
  liveDataUrl = 'http://127.0.0.1/api/get/liveData';

  constructor(private http: HttpClient) { }

  private fetchLiveData(): any {
    this.http.get(this.liveDataUrl).pipe().subscribe(liveData => {});
  }
}
