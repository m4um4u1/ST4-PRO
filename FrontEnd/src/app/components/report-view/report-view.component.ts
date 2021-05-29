import { Component, OnInit } from '@angular/core';
import {BatchReport} from '../../models/batch-report.model';
import {BatchReportService} from '../../services/batch-report.service';

@Component({
  selector: 'app-report-view',
  templateUrl: './report-view.component.html',
  styleUrls: ['./report-view.component.css']
})
export class ReportViewComponent implements OnInit {

  batchReports: BatchReport[];
  batchReport: BatchReport;
  id: number;

  constructor(private batchReportService: BatchReportService) { }

  ngOnInit(): void {
    /* this.batchReportService.getBatchReports().subscribe((response) => {
      this.batchReports = response;
    });
     */
  }

  searchBatchReport(id): void {
    this.batchReportService.findBatchReport(id).subscribe((response) => {
      this.batchReport = response;
    });
  }

}
