import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SellshareComponent } from './sellshare.component';

describe('SellshareComponent', () => {
  let component: SellshareComponent;
  let fixture: ComponentFixture<SellshareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SellshareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SellshareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
