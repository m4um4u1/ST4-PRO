export interface BatchReport {
  temperature: number;
  humidity: number;
  batchId: number;
  productType: number;
  totalAmount: number;
  acceptedAmount: number;
  defectAmount: number;
  date: Date;
}
