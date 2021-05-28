import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiveDataViewComponent } from './live-data-view.component';

describe('LiveDataViewComponent', () => {
  let component: LiveDataViewComponent;
  let fixture: ComponentFixture<LiveDataViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LiveDataViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LiveDataViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
