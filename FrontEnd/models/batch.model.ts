export class Batch {

  id: number;
  type: string;
  machineSpeed: number;
  productAmount: number;
  productsPerMinute: number;
  producedAmount: number;
  acceptable: number;
  defected: number;

  constructor(id: number, type: string, machineSpeed: number, productAmount: number) {
    this.id = id;
    this.type = type;
    this.machineSpeed = machineSpeed;
    this.productAmount = productAmount;
  }


}
