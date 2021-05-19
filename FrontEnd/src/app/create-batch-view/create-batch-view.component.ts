import {Component, OnInit} from '@angular/core';
import {BatchService} from '../batch.service';

@Component({
  selector: 'app-create-batch-view',
  templateUrl: './create-batch-view.component.html',
  styleUrls: ['./create-batch-view.component.css']
})
export class CreateBatchViewComponent implements OnInit {

  productType = 'Default';
  batchId = 0;
  productAmount = 0;
  machineSpeed = 0;

  constructor(private batchService: BatchService) { }

  ngOnInit(): void {
  }

  insertBatch(): void {
    this.batchService.createBatch(this.batchId, this.productType, this.machineSpeed, this.productAmount);
  }
}
