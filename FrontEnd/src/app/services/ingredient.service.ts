import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IngData} from '../models/ing-data.model';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  ingUrl = 'http://127.0.0.1:8080/api/ingredients/get';

  constructor(private http: HttpClient) {}

  getIngData(): Observable<IngData> {
     return this.http.get<IngData>(this.ingUrl);
  }
}
