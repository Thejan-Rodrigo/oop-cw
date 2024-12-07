import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SimConfigFormComponent } from './sim-config-form.component';

describe('SimConfigFormComponent', () => {
  let component: SimConfigFormComponent;
  let fixture: ComponentFixture<SimConfigFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SimConfigFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SimConfigFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
