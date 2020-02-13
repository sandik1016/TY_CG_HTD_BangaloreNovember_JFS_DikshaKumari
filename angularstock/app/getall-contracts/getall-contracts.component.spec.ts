import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallContractsComponent } from './getall-contracts.component';

describe('GetallContractsComponent', () => {
  let component: GetallContractsComponent;
  let fixture: ComponentFixture<GetallContractsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallContractsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallContractsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
