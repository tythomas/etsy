import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmptyGrComponent } from './empty-gr.component';

describe('EmptyGrComponent', () => {
  let component: EmptyGrComponent;
  let fixture: ComponentFixture<EmptyGrComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmptyGrComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmptyGrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
