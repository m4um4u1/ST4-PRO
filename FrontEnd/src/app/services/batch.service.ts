import {Injectable} from '@angular/core';
import {Batch} from '../../../models/batch.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class BatchService {

  private batch: Batch;
  private batchUrl = 'http://127.0.0.1/api/batch/postbatch';

  constructor(private http: HttpClient) { }

  sendBatch(): Observable<any> {
    console.log(this.batch);
    return this.http.post(this.batchUrl, this.batch);
  }

}
