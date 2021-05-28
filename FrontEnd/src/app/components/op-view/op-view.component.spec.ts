import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpViewComponent } from './op-view.component';

describe('OpViewComponent', () => {
  let component: OpViewComponent;
  let fixture: ComponentFixture<OpViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
