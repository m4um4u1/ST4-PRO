import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IngData} from '../../../models/ing-data.model';


@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  ingUrl = 'http://127.0.0.1/api/get/IngData';

  constructor(private http: HttpClient) {}

  getIngData(): void{
    this.http.get<IngData>(this.ingUrl).subscribe(data => {
      console.log(data);
    });
  }
}
