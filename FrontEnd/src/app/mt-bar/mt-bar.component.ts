import { Component, OnInit } from '@angular/core';
import {MaintenanceService} from '../services/maintenance.service';

@Component({
  selector: 'app-mt-bar',
  templateUrl: './mt-bar.component.html',
  styleUrls: ['./mt-bar.component.css']
})
export class MtBarComponent implements OnInit {

  mtProcent = 10;

  constructor(private mtData: MaintenanceService) { }

  private fetchMtData(): void{
    this.mtData.getMtData();
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchMtData(); }, 3000);
  }

}
