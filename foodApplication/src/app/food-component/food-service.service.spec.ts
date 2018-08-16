import { TestBed, inject } from '@angular/core/testing';

import { FoodServiceService } from './food-service.service';

describe('FoodServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FoodServiceService]
    });
  });

  it('should be created', inject([FoodServiceService], (service: FoodServiceService) => {
    expect(service).toBeTruthy();
  }));
});
