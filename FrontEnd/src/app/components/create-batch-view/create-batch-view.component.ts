import {Component, OnInit} from '@angular/core';
import {BatchService} from '../../services/batch.service';
import {Batch} from '../../models/batch.interface';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';
import {StateService} from "../../services/state.service";
import {State} from "../../models/state.model";

@Component({
  selector: 'app-create-batch-view',
  templateUrl: './create-batch-view.component.html',
  styleUrls: ['./create-batch-view.component.css']
})
export class CreateBatchViewComponent implements OnInit {

  productType = 0;
  batchId = 0;
  productAmount = 0;
  machineSpeed = 0;
  isIdle = false;
  state: State;

  public batch: Batch;
  constructor(private batchService: BatchService, private stateService: StateService) { }

  ngOnInit(): void {
      setInterval(() => {
        this.stateService.getStateData().subscribe((response: State) => {
          this.state = response;
        });
        if (this.state?.state === 4){
          this.isIdle = true;
          console.log(this.isIdle);
        } else {
          this.isIdle = false;
          console.log(this.isIdle);
        }
      }, 5000);

  }

  public onAddBatch(addForm: NgForm): void {
    console.log(addForm.value);
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
