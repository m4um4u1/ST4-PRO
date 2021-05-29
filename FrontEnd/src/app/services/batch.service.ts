import {Injectable} from '@angular/core';
import {Batch} from '../models/batch.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BatchService {

  private batchUrl = 'http://127.0.0.1:8080/api/batch/post';
  constructor(private http: HttpClient) { }

  sendBatch(batch: Batch): Observable<Batch> {
    return this.http.post<Batch>(this.batchUrl, batch);
  }
}
