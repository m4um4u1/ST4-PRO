import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBatchViewComponent } from './create-batch-view.component';

describe('CreateBatchViewComponent', () => {
  let component: CreateBatchViewComponent;
  let fixture: ComponentFixture<CreateBatchViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateBatchViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBatchViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
