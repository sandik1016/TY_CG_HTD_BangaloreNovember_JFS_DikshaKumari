import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallManagersComponent } from './getall-managers.component';

describe('GetallManagersComponent', () => {
  let component: GetallManagersComponent;
  let fixture: ComponentFixture<GetallManagersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetallManagersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetallManagersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
