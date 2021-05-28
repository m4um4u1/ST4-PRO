import { Component, OnInit } from '@angular/core';
import {LiveDataService} from '../../services/live-data.service';
import {LiveData} from '../../models/live-data.model';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-live-data-view',
  templateUrl: './live-data-view.component.html',
  styleUrls: ['./live-data-view.component.css']
})
export class LiveDataViewComponent implements OnInit {

  public data: LiveData;
  constructor(private liveData: LiveDataService) { }

  private fetchData(): void{
    this.liveData.fetchLiveData().subscribe((response: LiveData) => {
      this.data = response;
    }, (error: HttpErrorResponse) => { alert(error.message); });
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchData(); }, 3000);
    }
}
