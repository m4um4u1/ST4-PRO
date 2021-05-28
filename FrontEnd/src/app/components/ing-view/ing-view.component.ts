import { Component, OnInit } from '@angular/core';
import {IngredientService} from '../../services/ingredient.service';
import {IngData} from '../../models/ing-data.model';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-ing-view',
  templateUrl: './ing-view.component.html',
  styleUrls: ['./ing-view.component.css']
})
export class IngViewComponent implements OnInit {

  public data: IngData;

  constructor(private ingDataService: IngredientService) { }

  private fetchIngData(): void{
   this.ingDataService.getIngData().subscribe((response: IngData) => {
     response.malt = Math.round((response.malt / 35000) * 100);
     response.hops = Math.round((response.hops / 35000) * 100);
     response.yeast = Math.round((response.yeast / 35000) * 100);
     response.barley = Math.round((response.barley / 35000) * 100);
     response. wheat = Math.round((response.wheat / 35000) * 100);
     this.data = response;
   }, (error: HttpErrorResponse) => { alert(error.message); });
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchIngData(); }, 3000);
  }

}
