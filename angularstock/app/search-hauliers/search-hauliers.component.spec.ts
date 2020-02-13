import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchHauliersComponent } from './search-hauliers.component';

describe('SearchHauliersComponent', () => {
  let component: SearchHauliersComponent;
  let fixture: ComponentFixture<SearchHauliersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchHauliersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchHauliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
