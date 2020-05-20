import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryprobaComponent } from './categoryproba.component';

describe('CategoryprobaComponent', () => {
  let component: CategoryprobaComponent;
  let fixture: ComponentFixture<CategoryprobaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryprobaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryprobaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
