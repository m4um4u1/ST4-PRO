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
     response.malt = (response.malt / 35000) * 100;
     response.hops = (response.hops / 35000) * 100;
     response.yeast = (response.yeast / 35000) * 100;
     response.barley = (response.barley / 35000) * 100;
     response. wheat = (response.wheat / 35000) * 100;
     this.data = response;
   }, (error: HttpErrorResponse) => { alert(error.message); });
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchIngData(); }, 10000);
  }

}
