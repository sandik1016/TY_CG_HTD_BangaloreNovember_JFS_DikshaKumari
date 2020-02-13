import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallCustomersComponent } from './getall-customers.component';

describe('GetallCustomersComponent', () => {
  let component: GetallCustomersComponent;
  let fixture: ComponentFixture<GetallCustomersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallCustomersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallCustomersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
