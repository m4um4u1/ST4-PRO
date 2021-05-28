import {Injectable} from '@angular/core';
import {Batch} from '../models/batch.interface';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BatchService {

  private batchUrl = 'http://127.0.0.1:8080/api/batch/post';
  private batch: Batch;
  constructor(private http: HttpClient) { }

  sendBatch(): Observable<Batch> {
    return this.http.post<Batch>(this.batchUrl, this.batch);
  }

  createBatch(batch: Batch): void {
    this.batch = batch;
  }
}
