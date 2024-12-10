import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimTicketPoolComponent } from './sim-ticket-pool.component';

describe('SimTicketPoolComponent', () => {
  let component: SimTicketPoolComponent;
  let fixture: ComponentFixture<SimTicketPoolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SimTicketPoolComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SimTicketPoolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
