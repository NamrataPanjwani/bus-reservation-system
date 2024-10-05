import { TestBed } from '@angular/core/testing';

import { RouteService } from '../RouteService/route.service';

describe('BusesService', () => {
  let service: RouteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RouteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
