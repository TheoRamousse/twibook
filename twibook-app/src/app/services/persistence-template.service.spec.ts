import { TestBed } from '@angular/core/testing';

import { PersistenceTemplateService } from './persistence-template.service';

describe('PersistenceTemplateService', () => {
  let service: PersistenceTemplateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersistenceTemplateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
