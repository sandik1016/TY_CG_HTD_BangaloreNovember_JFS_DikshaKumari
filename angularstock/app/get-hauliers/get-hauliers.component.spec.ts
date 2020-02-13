import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetHauliersComponent } from './get-hauliers.component';

describe('GetHauliersComponent', () => {
  let component: GetHauliersComponent;
  let fixture: ComponentFixture<GetHauliersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetHauliersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetHauliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
