import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallProductsComponent } from './getall-products.component';

describe('GetallProductsComponent', () => {
  let component: GetallProductsComponent;
  let fixture: ComponentFixture<GetallProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
