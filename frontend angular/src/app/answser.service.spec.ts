import { TestBed } from '@angular/core/testing';

import { AnswserService } from './answser.service';

describe('AnswserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AnswserService = TestBed.get(AnswserService);
    expect(service).toBeTruthy();
  });
});
