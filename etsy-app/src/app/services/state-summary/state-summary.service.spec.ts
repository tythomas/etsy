import { TestBed, inject } from '@angular/core/testing';

import { StateSummaryService } from './state-summary.service';

describe('OrderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StateSummaryService]
    });
  });

  it('should be created', inject([StateSummaryService], (service: StateSummaryService) => {
    expect(service).toBeTruthy();
  }));
});
