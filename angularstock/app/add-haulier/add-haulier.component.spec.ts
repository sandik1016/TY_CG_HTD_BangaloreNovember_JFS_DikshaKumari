import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddHaulierComponent } from './add-haulier.component';

describe('AddHaulierComponent', () => {
  let component: AddHaulierComponent;
  let fixture: ComponentFixture<AddHaulierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddHaulierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddHaulierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
