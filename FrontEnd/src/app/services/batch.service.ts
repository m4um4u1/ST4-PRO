import {Injectable} from '@angular/core';
import {Batch} from '../../../models/batch.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BatchService {

  private batch: Batch;
  private batchUrl = 'http://127.0.0.1/api/batch';

  constructor(private http: HttpClient) { }

  createBatch(id: number, type: string, speed: number, amount: number): void {
    this.batch = new Batch(id, type, speed, amount);
  }

  sendBatch(): Observable<any> {
    console.log(this.batch);
    return this.http.post(this.batchUrl, this.batch);
  }

}
