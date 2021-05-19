import {Injectable, Input} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable({
  providedIn: 'root'
})
export class BatchService {


  private batchID;
  private productAmount;
  private machineSpeed;

  private productType = new BehaviorSubject<string>();
  currentProductType = this.productType.asObservable();



  constructor() { }

  changeProductType(message: string){
    this.productType.next(message);
  }

  createBatchData = {
    productType: this.productType,
    batchID: this.batchID,
    productAmount: this.productAmount,
    machineSpeed: this.machineSpeed
  };

}
