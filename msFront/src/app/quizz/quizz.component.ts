import {Component, Input} from '@angular/core';
import {QuizzModel} from "../model/Quizz.model";

@Component({
  selector: 'app-quizz',
  templateUrl: './quizz.component.html',
  styleUrl: './quizz.component.css'
})
export class QuizzComponent {
  @Input() quizz!:QuizzModel;
}
