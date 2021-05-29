import { Component, OnInit } from '@angular/core';
import {LiveDataService} from '../../services/live-data.service';
import {LiveData} from '../../models/live-data.model';
import {HttpErrorResponse} from '@angular/common/http';
import {BatchReportService} from "../../services/batch-report.service";
import {State} from "../../models/state.model";
import {StateService} from "../../services/state.service";

@Component({
  selector: 'app-live-data-view',
  templateUrl: './live-data-view.component.html',
  styleUrls: ['./live-data-view.component.css']
})
export class LiveDataViewComponent implements OnInit {

  public data: LiveData;
  public state: State;
  constructor(private liveData: LiveDataService, private batchReportService: BatchReportService, private stateService: StateService) { }

  private fetchData(): void{
    this.liveData.fetchLiveData().subscribe((response: LiveData) => {
      this.data = response;
    }, (error: HttpErrorResponse) => { console.log(error.message); });
  }

  ngOnInit(): void {
    setInterval(() => {
      this.stateService.getStateData().subscribe((response: State) => {
        this.state = response;
      });
      this.fetchData(); }, 3000);
    }
}
