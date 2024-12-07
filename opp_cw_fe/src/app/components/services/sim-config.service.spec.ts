import { TestBed } from '@angular/core/testing';

import { SimConfigService } from './sim-config.service';

describe('SimConfigService', () => {
  let service: SimConfigService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SimConfigService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
