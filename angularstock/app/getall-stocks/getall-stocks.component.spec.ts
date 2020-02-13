import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallStocksComponent } from './getall-stocks.component';

describe('GetallStocksComponent', () => {
  let component: GetallStocksComponent;
  let fixture: ComponentFixture<GetallStocksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallStocksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallStocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
