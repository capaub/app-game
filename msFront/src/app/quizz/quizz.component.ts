import {Component, EventEmitter, Input, Output} from '@angular/core';
import {QuizzModel} from "../model/Quizz.model";
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrl: './quizz.component.css'
})
export class QuizzComponent extends AppComponent{
  @Input() quizz!: QuizzModel;
  @Output() public send = new EventEmitter();
  @Output() public nextIndex = new EventEmitter();


  sendResponse(questionId: number, responseId: number,quizz:QuizzModel) {
    this.send.emit({questionId, responseId});
    this.nextIndex.emit(this.index + 1);
    this.index += 1;
    this.countPoint(responseId,quizz);
  }
}
