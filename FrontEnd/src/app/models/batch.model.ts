import {Batch} from './batch.interface';

export class BatchModel implements Batch {
  amount: number;
  id: number;
  machSpeed: number;
  productType: number;


  constructor(amount: number, id: number, machSpeed: number, productType: number) {
    this.amount = amount;
    this.id = id;
    this.machSpeed = machSpeed;
    this.productType = productType;
  }
}
