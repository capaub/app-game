import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './finalScore.component.html',
  styleUrl: './finalScore.component.css'
})
export class FinalScoreComponent implements OnInit{
  @Input() point!: number;
  @Input() timer!: number;
  ngOnInit(): void {
  }

}
