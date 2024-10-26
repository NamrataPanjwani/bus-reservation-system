// revenue-report.model.ts
export class RevenueReport {
    busId: number;
    operator: string;
    busNumber: string;
    totalRevenue: number;
  
    constructor(busId: number, operator: string, busNumber: string, totalRevenue: number) {
      this.busId = busId;
      this.operator = operator;
      this.busNumber = busNumber;
      this.totalRevenue = totalRevenue;
    }
  }
  