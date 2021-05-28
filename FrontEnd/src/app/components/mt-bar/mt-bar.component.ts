import { Component, OnInit } from '@angular/core';
import {MaintenanceService} from '../../services/maintenance.service';
import {Maintenance} from '../../models/maintenance.model';

@Component({
  selector: 'app-mt-bar',
  templateUrl: './mt-bar.component.html',
  styleUrls: ['./mt-bar.component.css']
})
export class MtBarComponent implements OnInit {

 public data: Maintenance;

  constructor(private mtData: MaintenanceService) { }

  private fetchMtData(): void{
    this.mtData.getMtData().subscribe((response: Maintenance) => {
     response.maintenance = (response.maintenance / 65535 ) * 100;
     this.data = response;
    });
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchMtData(); }, 3000);
  }

}
