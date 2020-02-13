import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvestorcompanyComponent } from './investorcompany.component';

describe('InvestorcompanyComponent', () => {
  let component: InvestorcompanyComponent;
  let fixture: ComponentFixture<InvestorcompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvestorcompanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvestorcompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
