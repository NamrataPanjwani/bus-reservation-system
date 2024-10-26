import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Reservation } from '../Models/reservation';
import { RevenueReport } from '../Models/revenue';

export interface RevenueResponse {
  report: RevenueReport[];
  totalRevenue: number;
}

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private revenueDatSubject = new BehaviorSubject<any>(null)
   revenueData$ = this.revenueDatSubject.asObservable()

  
  private baseUrl = 'http://localhost:8080/api/seats';

  constructor(private http: HttpClient) {}

  getTicket(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${this.baseUrl}/getTicket/${id}`);
  }

  getAllTickets(busId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/getAllTicket/${busId}`);
  }

  createTicket(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.baseUrl}/createTicket`, reservation);
  }

  deleteTicket(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/deleteTicket/${id}`);
  }

  getReservations(userId: number, busId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.baseUrl}/search/userId/${userId}/busId/${busId}`);
  }
  getBookedSeats(busId:number,date:string):Observable<number[]>{
    return this.http.get<number[]>(`${this.baseUrl}/bookedSeats/${busId}/${date}`);
  }

  getRevenueOfBuses(): Observable<RevenueReport[]> {
    // Check if revenue data is already available
    if (this.revenueDatSubject.value !== null) {
      return this.revenueData$; // Return the existing observable
    } else {
      // If not, fetch the revenue data from the API
      return this.fetchRevenueOfBuses().pipe(
        tap(data => this.revenueDatSubject.next(data)) // Update the BehaviorSubject with new data
      );
    }
  }
  

  fetchRevenueOfBuses():Observable<RevenueReport[]>{
    return this.http.get<RevenueReport[]>('http://localhost:8080/api/seats/total-revenue/rajvi-travels')
  }

  
}
