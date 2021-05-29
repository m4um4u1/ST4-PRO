import { Component, OnInit } from '@angular/core';
import {BatchReport} from '../../models/batch-report.model';
import {BatchReportService} from '../../services/batch-report.service';
import {State} from '../../models/state.model';

@Component({
  selector: 'app-report-view',
  templateUrl: './report-view.component.html',
  styleUrls: ['./report-view.component.css']
})
export class ReportViewComponent implements OnInit {

  batchReports: BatchReport[];
  batchReport: BatchReport;
  id: number;
  state: State;

  constructor(private batchReportService: BatchReportService) { }

  ngOnInit(): void {
     this.batchReportService.getBatchReports().subscribe((response) => {
      this.batchReports = response;
    });
  }

  searchBatchReport(id: number): void {
    this.batchReportService.findBatchReport(id).subscribe((response) => {
      this.batchReport = response;
      this.batchReports = [];
      this.batchReports.push(this.batchReport);
    });
  }

}
