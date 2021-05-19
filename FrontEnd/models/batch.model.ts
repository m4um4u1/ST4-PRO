export class Batch {

  id: number;
  type: string;
  machineSpeed: number;
  productAmount: number;

  constructor(id: number, type: string, machineSpeed: number, productAmount: number) {
    this.id = id;
    this.type = type;
    this.machineSpeed = machineSpeed;
    this.productAmount = productAmount;
  }

}
