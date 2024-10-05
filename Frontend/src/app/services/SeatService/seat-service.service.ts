import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SeatServiceService {
  private selectedRouteSubject = new BehaviorSubject<any>(null);
  selectedRoute = this.selectedRouteSubject.asObservable();

  constructor(private http: HttpClient) {}

  selectRoute(route: any) {
    this.selectedRouteSubject.next(route);
  }

  // Method to fetch buses for a specific route from backend
  getBusesForRoute(id:number): Observable<any[]> {
    return this.http.get<any[]>(`http://localhost:8080/api/busSchedule/route/${id}`);
  }

  selectBus(bus: any) {
    // Logic for selecting the bus
  }
}





// import { Injectable } from '@angular/core';
// import { BehaviorSubject } from 'rxjs';
// interface Bus {
//   name: string;
//   route: string;
//   departureTime: string;
//   arrivalTime: string;
// }
// @Injectable({
//   providedIn: 'root'
// })
// export class SeatServiceService {

//   private selectedBusSource = new BehaviorSubject<Bus | null>(null);
//   currentBus = this.selectedBusSource.asObservable();

//   private selectedRouteSource = new BehaviorSubject<any>(null);
//   selectedRoute = this.selectedRouteSource.asObservable();

//   constructor() {}

//   selectBus(bus: Bus) {
//     this.selectedBusSource.next(bus);
//   }
//   selectRoute(route: any) {
//     this.selectedRouteSource.next(route);
//   }
// }
// =--------

// export class SeatServiceService {
//   private selectedRouteSource = new BehaviorSubject<any>(null);
//   selectedRoute$ = this.selectedRouteSource.asObservable();

//   selectRoute(route: any) {
//     this.selectedRouteSource.next(route);
//   }
// }

