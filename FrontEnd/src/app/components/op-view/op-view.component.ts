import { Component, OnInit } from '@angular/core';
import {ButtonServiceService} from '../../services/button-service.service';
import {BatchService} from '../../services/batch.service';

@Component({
  selector: 'app-op-view',
  templateUrl: './op-view.component.html',
  styleUrls: ['./op-view.component.css']
})
export class OpViewComponent implements OnInit {

  constructor(private buttonService: ButtonServiceService, private batchService: BatchService) { }

  ngOnInit(): void {
  }

  start(): void {
    this.buttonService.postCommand(2).subscribe(data => {console.log(data); });
  }

  stop(): void {
    this.buttonService.postCommand(3).subscribe(data => {console.log(data); });
  }

  reset(): void {
    this.buttonService.postCommand(1).subscribe(data => {console.log(data); });
  }

  clear(): void {
    this.buttonService.postCommand(5).subscribe(data => {console.log(data); });
  }

  abort(): void {
    this.buttonService.postCommand(4).subscribe(data => {console.log(data); });
  }

}
