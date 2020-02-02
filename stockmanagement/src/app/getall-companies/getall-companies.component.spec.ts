import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallCompaniesComponent } from './getall-companies.component';

describe('GetallCompaniesComponent', () => {
  let component: GetallCompaniesComponent;
  let fixture: ComponentFixture<GetallCompaniesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallCompaniesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallCompaniesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
