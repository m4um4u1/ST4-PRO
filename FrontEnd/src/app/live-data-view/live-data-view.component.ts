import { Component, OnInit } from '@angular/core';
import {LiveDataService} from '../services/live-data.service';

@Component({
  selector: 'app-live-data-view',
  templateUrl: './live-data-view.component.html',
  styleUrls: ['./live-data-view.component.css']
})
export class LiveDataViewComponent implements OnInit {

  constructor(private liveData: LiveDataService) { }

  private fetchData(): void{
    this.liveData.fetchLiveData();
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchData(); }, 3000);
    }
}
