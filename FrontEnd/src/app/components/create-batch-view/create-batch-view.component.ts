import {Component, OnInit} from '@angular/core';
import {BatchService} from '../../services/batch.service';
import {Batch} from '../../models/batch.interface';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';

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

  public batch: Batch;
  constructor(private batchService: BatchService) { }

  ngOnInit(): void {
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
