import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { ReservationService } from '../../Services/reservation.service';
import { CommonModule } from '@angular/common';
import { RevenueReport } from '../../Models/revenue';

export interface RevenueResponse {
  report: RevenueReport[];
  totalRevenue: number;
}


@Component({
  selector: 'app-revenue-report',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './revenue-report.component.html',
  styleUrls: ['./revenue-report.component.css']
})
export class RevenueReportComponent implements OnInit {
  revenueData: RevenueReport[] = []; 
  totalRevenue!:number;

  constructor(private reservationService: ReservationService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.reservationService.getRevenueOfBuses().subscribe({
      next: (data:any) => {
        console.log("Data: ",data);
        this.revenueData = data.report
        this.totalRevenue = data.totalRevenue
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

}
