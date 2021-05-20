import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  IngUrl = 'http://127.0.0.1/api/get/IngData';

  constructor(private http: HttpClient) {
  }
}
