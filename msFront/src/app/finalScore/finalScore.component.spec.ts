import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinalScoreComponent } from './finalScore.component';

describe('MenuComponent', () => {
  let component: FinalScoreComponent;
  let fixture: ComponentFixture<FinalScoreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FinalScoreComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinalScoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
