import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IngData} from '../models/ing-data.model';
import {BatchReport} from '../models/batch-report.model';

@Injectable({
  providedIn: 'root'
})
export class BatchReportService {

  reportUrl = 'http://localhost:8080/api/report';

  constructor(private http: HttpClient) { }

  getBatchReports(): Observable<BatchReport[]> {
    return this.http.get<BatchReport[]>(`${this.reportUrl}/all`);
  }

  findBatchReport(id: number): Observable<BatchReport> {
    return this.http.get<BatchReport>(`${this.reportUrl}/find/${id}`);
  }
}
