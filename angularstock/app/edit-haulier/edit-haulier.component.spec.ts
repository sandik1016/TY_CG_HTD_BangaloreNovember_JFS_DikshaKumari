import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditHaulierComponent } from './edit-haulier.component';

describe('EditHaulierComponent', () => {
  let component: EditHaulierComponent;
  let fixture: ComponentFixture<EditHaulierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditHaulierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditHaulierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
