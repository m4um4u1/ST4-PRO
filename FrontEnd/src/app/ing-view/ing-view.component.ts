import { Component, OnInit } from '@angular/core';
import {IngredientService} from '../services/ingredient.service';

@Component({
  selector: 'app-ing-view',
  templateUrl: './ing-view.component.html',
  styleUrls: ['./ing-view.component.css']
})
export class IngViewComponent implements OnInit {

  barleyProcent = 56;
  maltProcent = 20;
  hopsProcent = 12;
  wheatProcent = 26;
  yeastProcent = 80;

  constructor(private ingData: IngredientService) { }

  private fetchIngData(): void{
    this.ingData.getIngData();
  }

  ngOnInit(): void {
    setInterval(() => {
      this.fetchIngData(); }, 3000);
  }

}
