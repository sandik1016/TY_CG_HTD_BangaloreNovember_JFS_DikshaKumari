import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallOrdersComponent } from './getall-orders.component';

describe('GetallOrdersComponent', () => {
  let component: GetallOrdersComponent;
  let fixture: ComponentFixture<GetallOrdersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallOrdersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
