import {Component, EventEmitter, Input, Output, OnInit, OnChanges, SimpleChanges} from '@angular/core';
import {QuizzModel} from "../model/Quizz.model";

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrl: './quizz.component.css'
})

export class QuizzComponent implements OnInit, OnChanges{
  @Input() quizz!: QuizzModel;
  @Input() index!: number;
  @Output() public userResponse:EventEmitter<[number,number]> = new EventEmitter<[number, number]>();
  @Output() public nextIndex:EventEmitter<number> = new EventEmitter();
  @Output() public timer:EventEmitter<number> = new EventEmitter();

  valueOfTimer = 15;
  totalTime:number = 0;
  timerValue: number = this.valueOfTimer;
  timerInterval: any;
  ngOnInit() {
    this.startTimer();
  }
  ngOnChanges(changes: SimpleChanges) {
    if (changes['index'] && !changes['index'].firstChange) {
      this.timerValue = 15;
      this.startTimer();
    }
  }

  sendResponse(questionId: number, responseId: number|null) {
      this.stopTimer()
      const q: number = parseInt(String(questionId))
      const r: number = parseInt(String(responseId))
      this.userResponse.emit([<number>q, <number>r]);
      this.nextIndex.emit(this.index + 1);
      this.timer.emit(this.totalTime)
  }

  startTimer() {
    this.timerInterval = setInterval(() => {
      if (this.timerValue > 0) {
        this.timerValue--;
      } else {
        this.stopTimer();
        this.sendResponse(this.quizz.questionO.id,null);
      }
    }, 1000);
  }

  stopTimer() {
    this.totalTime += (this.valueOfTimer - this.timerValue)
    clearInterval(this.timerInterval);
  }
}
