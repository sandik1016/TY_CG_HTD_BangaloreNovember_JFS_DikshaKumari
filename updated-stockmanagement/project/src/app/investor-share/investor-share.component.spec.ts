import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvestorShareComponent } from './investor-share.component';

describe('InvestorShareComponent', () => {
  let component: InvestorShareComponent;
  let fixture: ComponentFixture<InvestorShareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvestorShareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvestorShareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
