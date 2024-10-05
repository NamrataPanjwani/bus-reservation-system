import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
// import { Buses } from '../Models/buses.model';

@Injectable({
  providedIn: 'root',
})
export class RouteService {
  constructor(private http: HttpClient) {}

  getRoutes(): Observable<string[]> {
    console.log('Success!');

    return this.http.get<string[]>('http://localhost:8080/api/route/list');
  }

  getRoutesById(id:number): Observable<string[]> {
    console.log('Success!');

    return this.http.get<string[]>(`http://localhost:8080/api/route/find/${id}`);
  }


  searchRoutes(from: string, to: string): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/route/search', {
      params: {
        source: from,
        destination: to
      }
    });
  }
}
