import { TestBed } from '@angular/core/testing';

import { ForestService } from './forest.service';

describe('ForestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ForestService = TestBed.get(ForestService);
    expect(service).toBeTruthy();
  });
});
