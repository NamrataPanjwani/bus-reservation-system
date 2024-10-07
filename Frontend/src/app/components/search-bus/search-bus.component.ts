import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SeatServiceService } from '../../services/SeatService/seat-service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-search-bus',
  standalone: true,
  templateUrl: './search-bus.component.html',
  styleUrl: './search-bus.component.css',
  imports:[CommonModule]
})
export class SearchBusComponent implements OnInit, OnDestroy {
  route = inject(Router);
  buses: any[] = [];  
  selectedRoute: any;

  constructor(private seatService: SeatServiceService) {}

  ngOnDestroy(): void {
    this.selectedRoute = null;
  }

  ngOnInit() {
   
    this.seatService.selectedRoute.subscribe(route => {
      this.selectedRoute = route;
      console.log('Selected route:', this.selectedRoute);

      if (this.selectedRoute) {
       
        this.seatService.getBusesForRoute(this.selectedRoute.id, this.selectedRoute.date.toISOString().split('T')[0]).subscribe(buses => {
          this.buses = buses; 
          console.log('Available buses:', this.buses);
        });
      }
    });
  }

  selectBus(bus: any) {
    this.seatService.selectBus(bus);
    this.route.navigateByUrl('seats');
  }
}




// import { CommonModule } from '@angular/common';
// import { Component, inject, OnDestroy, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { SeatServiceService } from '../../services/SeatService/seat-service.service';
// import { BusService } from '../../services/BusService/bus-service.service';



// @Component({
//   selector: 'app-search-bus',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './search-bus.component.html',
//   styleUrl: './search-bus.component.css'
// })
// export class SearchBusComponent implements OnInit, OnDestroy{
//   route=inject(Router)
//   buses = [
//     { id: 1, name: 'Luxury Coach A (LC123)', arrivalTime: '10:00 AM', departureTime: '08:00 AM', duration: '2h', price: 500 },

//   ];

// constructor(private seatService: SeatServiceService, private busService:BusService) {}
//   ngOnDestroy(): void {
//    this.selectedRoute=null;
//   }
// selectedRoute: any;

 
// ngOnInit() {
//   this.seatService.selectedRoute.subscribe(route => {
//     this.selectedRoute = route;
//     if (this.selectedRoute && this.selectedRoute.routeId) {
//       this.busService.getBusesByRoute(this.selectedRoute.routeId).subscribe(buses => {
//         this.buses = buses;
//       });
//     }
//   });
// }




// --------------
  // ngOnInit() {
  //   // debugger;
  //   this.seatService.selectedRoute.subscribe(route => {
  //     this.selectedRoute = route;
  //     // debugger;
  //     console.log('Selected route:', this.selectedRoute);
  //   });
  // }

//   selectBus(bus: any) {
//     this.seatService.selectBus(bus);
//     this.route.navigateByUrl('seats');
//   }



  

// }


/*
import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SeatServiceService } from '../../app/services/seat-service.service';

@Component({
  selector: 'app-search-bus',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './search-bus.component.html',
  styleUrls: ['./search-bus.component.css']
})
export class SearchBusComponent implements OnInit {
  route = inject(Router);
  buses = [
    { id: 1, name: 'Luxury Coach A (LC123)', arrivalTime: '10:00 AM', departureTime: '08:00 AM', duration: '2h', price: 500 },
    // Add more bus objects as needed
  ];

  selectedRoute: any;

  constructor(private busService: SeatServiceService) {}

  ngOnInit() {
    this.busService.selectedRoute$.subscribe(route => {
      this.selectedRoute = route;
      console.log('Selected route:', this.selectedRoute);
    });
  }

  selectBus(bus: any) {
    this.busService.selectBus(bus);
    this.route.navigateByUrl('seats');
  }
}

*/