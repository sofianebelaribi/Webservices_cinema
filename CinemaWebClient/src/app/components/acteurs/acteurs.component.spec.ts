import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActeursComponent } from './acteurs.component';

describe('ActeursComponent', () => {
  let component: ActeursComponent;
  let fixture: ComponentFixture<ActeursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActeursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActeursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
