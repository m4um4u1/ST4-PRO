import {Component, OnInit} from '@angular/core';
import {BatchService} from '../../services/batch.service';
import {Batch} from '../../models/batch.model';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import {StateService} from '../../services/state.service';
import {State} from '../../models/state.model';
import {BatchReportService} from '../../services/batch-report.service';
import {LiveData} from '../../models/live-data.model';
import {LiveDataService} from '../../services/live-data.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-create-batch-view',
  templateUrl: './create-batch-view.component.html',
  styleUrls: ['./create-batch-view.component.css']
})
export class CreateBatchViewComponent implements OnInit {


  productType: number;
  batchId: number;
  productAmount: number;
  machineSpeed: number;
  isIdle = false;
  isComplete = false;
  state: State;
  liveData: LiveData;

  public batch: Batch;

  constructor(private batchService: BatchService, private stateService: StateService, private batchReportService: BatchReportService,
              private liveDataService: LiveDataService) { }

  ngOnInit(): void {
      setInterval(() => {
        this.stateService.getStateData().subscribe((response: State) => {
          this.state = response;
        });
        if (this.state?.state === 4){
          this.isIdle = true;
        } else if (this.state?.state === 17){
          this.isComplete = true;
        } else {
          this.isIdle = false;
          this.isComplete = false;
        }
      }, 5000);

  }

  public onGenerateReport(): void {
    this.isComplete = false;
    this.liveDataService.fetchLiveData().subscribe((response) => {
      this.liveData = response;
    });
    this.batchReportService.createBatchReport(this.liveData).subscribe(
      (response) => {
        console.log(response);
      }, (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddBatch(addForm: NgForm): void {
    this.batchService.sendBatch(addForm.value).subscribe(
      (response: Batch) => {
        console.log(response);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }
}
