import {Component, EventEmitter, Input, Output} from '@angular/core';
import {QuizzModel} from "../model/Quizz.model";

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrl: './quizz.component.css'
})
export class QuizzComponent {
  @Input() quizz!: QuizzModel;
  @Output() public send = new EventEmitter();
  @Output() public nextIndex = new EventEmitter();

  index = 0;

  sendResponse(questionId: number, question: string, responseId: number, response: string) {
    this.send.emit({questionId, question, responseId, response})
    this.nextIndex.emit(this.index + 1)
    this.index += 1;
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
