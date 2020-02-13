import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanymanagerComponent } from './companymanager.component';

describe('CompanymanagerComponent', () => {
  let component: CompanymanagerComponent;
  let fixture: ComponentFixture<CompanymanagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompanymanagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanymanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
