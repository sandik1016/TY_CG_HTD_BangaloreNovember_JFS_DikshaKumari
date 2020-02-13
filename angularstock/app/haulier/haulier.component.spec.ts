import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HaulierComponent } from './haulier.component';

describe('HaulierComponent', () => {
  let component: HaulierComponent;
  let fixture: ComponentFixture<HaulierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HaulierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaulierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
