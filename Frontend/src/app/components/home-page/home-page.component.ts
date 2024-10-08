import { Component, OnDestroy, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
} from '@angular/forms';
import { CalendarModule } from 'primeng/calendar';
import { RouteService } from '../../services/RouteService/route.service';
import { CommonModule } from '@angular/common';

import { Router } from '@angular/router';
import { SeatServiceService } from '../../services/SeatService/seat-service.service';
import { Routes } from '../../models/routes.model';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  standalone: true,
  imports: [CalendarModule, FormsModule, ReactiveFormsModule, CommonModule],
})
export class HomePageComponent implements OnInit, OnDestroy {
  busForm: FormGroup;
  // fromOptions: string[] = [];
  // toOptions: string[] = [];
  // id?: number[];
  routes:Routes[]=[];

  constructor(
    private fb: FormBuilder,
    private routeService: RouteService,
    private seatService: SeatServiceService,
    private router: Router
  ) {
    this.busForm = this.fb.group({
      from: [''],
      to: [''],
      date: [null],
    });
  }
  ngOnDestroy(): void {}

  ngOnInit(): void {
    this.loadRoutes();
  }

  loadRoutes() {
    this.routeService.getRoutes().subscribe({
      next: (routes: any[]) => {
        console.log("(===================================)");
        console.log(routes);
        this.routes=routes;

        // this.fromOptions = routes.map((route) => route.source);
        // this.toOptions = routes.map((route) => route.destination);
        // this.id = routes.map((route) => route.id);
      },
      error: (error) => {
        console.error('Error fetching routes', error);
      },
    });
  }

  getBuses() {
    if (this.busForm.valid) {
      const formValues = this.busForm.value;
      var selectedId = this.routes.find(route => 
        route.source=== formValues.from && 
        route.destination === formValues.to
    )?.id;
      console.log('Selected departure city:', formValues.from);
      console.log('Selected destination city:', formValues.to);
      console.log('Selected date:', formValues.date.toISOString().split('T')[0]);
      console.log('Selected id:',  selectedId);

      this.seatService.selectRoute({
        from: formValues.from,
        to: formValues.to,
        date: formValues.date,
        id: selectedId
      });

      this.router.navigate(['/search']);
    } else {
      console.log('Form is invalid');
    }
  }
}
