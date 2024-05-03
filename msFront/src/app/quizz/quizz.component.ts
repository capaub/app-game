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


 /* //affichage composant choix level-theme:
 isClick()
 {
    // @ts-ignore
    let element = event.currentTarget
    // @ts-ignore
    element.classList.toggle("selected")
    console.log(element.classList)

    //let elts= document.querySelectorAll(".btn")
    //for(let i =0; i<elts.length, i++)
 } */
}
