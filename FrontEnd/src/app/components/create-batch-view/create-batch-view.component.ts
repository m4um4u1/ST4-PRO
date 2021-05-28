import {Component, OnInit} from '@angular/core';
import {BatchService} from '../../services/batch.service';
import {Batch} from '../../models/batch.interface';
import {BatchModel} from '../../models/batch.model';

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

  insertBatch(): void {
    this.batch = new BatchModel(this.productAmount, this.batchId, this.machineSpeed, this.productType);
    this.batchService.createBatch(this.batch);
  }
}
