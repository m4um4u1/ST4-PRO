import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MtBarComponent } from './mt-bar.component';

describe('MtBarComponent', () => {
  let component: MtBarComponent;
  let fixture: ComponentFixture<MtBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MtBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MtBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
