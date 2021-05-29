export interface BatchReport {
  temperature: number[];
  humidity: number[];
  batchID: number;
  productType: number;
  amount: number;
  machSpeed?: number;
  produced: number;
  accepted: number;
  defective: number;
  date: Date;
}
