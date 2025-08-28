import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'app-final-score',
  templateUrl: './final-score.component.html',
  styleUrl: './final-score.component.css'
})
export class FinalScoreComponent implements OnInit{
  @Input() point!: number;
  @Input() timer!: number;
  ngOnInit(): void {
  }

}
