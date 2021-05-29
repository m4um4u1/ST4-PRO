export interface LiveData {
   batchID: number;
   produced: number;
   accepted: number;
   defective: number;
   machSpeed?: number;
   amount: number;
   temperature: number;
   humidity: number;
   vibration?: number;
}
